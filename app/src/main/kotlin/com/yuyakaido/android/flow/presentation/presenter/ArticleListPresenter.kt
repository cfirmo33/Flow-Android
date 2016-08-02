package com.yuyakaido.android.flow.presentation.presenter

import android.widget.ListView
import com.jakewharton.rxbinding.widget.RxAbsListView
import com.yuyakaido.android.flow.app.Flow
import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.domain.entity.Site
import com.yuyakaido.android.flow.domain.usecase.GetArticleUseCase
import com.yuyakaido.android.flow.presentation.fragment.ArticleListFragment
import com.yuyakaido.android.flow.util.ErrorHandler
import com.yuyakaido.android.flow.util.ListViewUtil
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by yuyakaido on 7/31/16.
 */
class ArticleListPresenter(val fragment: ArticleListFragment, val site: Site, val category: Category) : Presenter {

    private val subscriptions = CompositeSubscription()

    @Inject
    lateinit var getArticleUseCase: GetArticleUseCase

    lateinit var fetcher: () -> Observable<List<Article>>

    init {
        Flow.getAppComponent(fragment.context)
                .newPresentationComponent()
                .newArticleListComponent()
                .inject(this)
    }

    override fun onCreate() {
        fetcher = getArticleUseCase.getArticleFetcher(site, category)
        fragment.initialize()
        loadArticles(fetcher())
    }

    override fun onDestroy() {
        subscriptions.unsubscribe()
    }

    override fun refresh() {
        fetcher = getArticleUseCase.getArticleFetcher(site, category)
        fragment.clearArticles()

        loadArticlesWithDelay()
    }

    fun registerScrollEvent(listView: ListView) {
        subscriptions.add(RxAbsListView.scrollEvents(listView)
                .filter(ListViewUtil.shouldPaginate())
                .distinctUntilChanged { e1, e2 -> e1.totalItemCount() == e2.totalItemCount() }
                .subscribe(
                        { loadArticlesWithDelay() },
                        { ErrorHandler.handle(it) }))
    }

    fun loadArticles(observable: Observable<List<Article>>) {
        subscriptions.add(observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { fragment.showProgressBar() }
                .doAfterTerminate { fragment.hideProgressBar() }
                .subscribe(
                        { fragment.addArticles(it) },
                        { ErrorHandler.handle(it) }))
    }

    fun loadArticlesWithDelay() {
        val observable = Observable.zip(
                Observable.timer(500, TimeUnit.MILLISECONDS),
                fetcher(),
                { delayMs, articles -> articles })

        loadArticles(observable)
    }

}