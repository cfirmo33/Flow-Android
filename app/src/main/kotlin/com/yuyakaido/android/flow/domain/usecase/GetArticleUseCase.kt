package com.yuyakaido.android.flow.domain.usecase

import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.domain.entity.Site
import com.yuyakaido.android.flow.infra.repository.MenthasRepository
import com.yuyakaido.android.flow.infra.repository.QiitaRepository
import rx.Observable
import rx.Single

/**
 * Created by yuyakaido on 7/30/16.
 */
class GetArticleUseCase(
        private val menthasRepository: MenthasRepository,
        private val qiitaRepository: QiitaRepository) {

    fun getArticles(site: Site, category: Category): Single<List<Article>> {
        return when (site) {
            Site.Menthas -> menthasRepository.getArticles(category)
            Site.Qiita -> qiitaRepository.getArticles(category)
            else -> {
                Observable.empty<List<Article>>().toSingle()
            }
        }
    }

}