package com.yuyakaido.android.flow.domain.usecase

import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.domain.entity.Site
import com.yuyakaido.android.flow.infra.repository.HatenaRepository
import com.yuyakaido.android.flow.infra.repository.MenthasRepository
import com.yuyakaido.android.flow.infra.repository.QiitaRepository
import com.yuyakaido.android.flow.presentation.fragment.ArticleListFragment
import com.yuyakaido.android.flow.presentation.item.QiitaSubscription
import rx.Observable
import javax.inject.Inject

/**
 * Created by yuyakaido on 7/30/16.
 */
class GetArticleUseCase @Inject constructor(
        private val menthasRepository: MenthasRepository,
        private val qiitaRepository: QiitaRepository,
        private val hatenaRepository: HatenaRepository) {

    fun getArticleFetcher(component: ArticleListFragment.Component): () -> Observable<List<Article>> {
        return when (component.site) {
            Site.Menthas -> getMenthasArticleFetcher(component.category!!)
            Site.Qiita -> getQiitaArticleFetcher(component.qiitaSubscription!!)
            Site.HatenaHot -> getHatenaHotArticleFetcher(component.category!!)
            Site.HatenaNew -> getHatenaNewArticleFetcher(component.category!!)
            else -> {
                fun () = Observable.empty<List<Article>>()
            }
        }
    }

    fun getMenthasArticleFetcher(category: Category): () -> Observable<List<Article>> {
        var isFetching = false
        var offset = 0
        return fun () = Observable.just(isFetching)
                .filter { !isFetching }
                .doOnNext { isFetching = true }
                .flatMap { menthasRepository.getArticles(category, offset).toObservable() }
                .doOnNext { isFetching = false }
                .doOnNext { offset += it.size }
    }

    fun getQiitaArticleFetcher(qiitaSubscription: QiitaSubscription): () -> Observable<List<Article>> {
        var isFetching = false
        var page = 1
        return fun () = Observable.just(isFetching)
                .filter { !isFetching }
                .doOnNext { isFetching = true }
                .flatMap { qiitaRepository.getArticles(qiitaSubscription, page).toObservable() }
                .doOnNext { isFetching = false }
                .doOnNext { page++ }
    }

    fun getHatenaHotArticleFetcher(category: Category): () -> Observable<List<Article>> {
        var isFirstFetch = true
        return fun () = Observable.just(isFirstFetch)
                .filter { isFirstFetch }
                .doOnNext { isFirstFetch = false }
                .flatMap { hatenaRepository.getHotArticles(category).toObservable() }
    }

    fun getHatenaNewArticleFetcher(category: Category): () -> Observable<List<Article>> {
        var isFirstFetch = true
        return fun () = Observable.just(isFirstFetch)
                .filter { isFirstFetch }
                .doOnNext { isFirstFetch = false }
                .flatMap { hatenaRepository.getNewArticles(category).toObservable() }
    }

}