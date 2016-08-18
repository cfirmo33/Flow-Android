package com.yuyakaido.android.flow.presentation.presenter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.yuyakaido.android.flow.app.Flow
import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.usecase.GetArticleUseCase
import com.yuyakaido.android.flow.presentation.fragment.ArticleListFragment
import com.yuyakaido.android.flow.presentation.misc.PaginationHandler
import com.yuyakaido.android.flow.util.ErrorHandler
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by yuyakaido on 7/31/16.
 */
class ArticleListPresenter(val fragment: ArticleListFragment, val component: ArticleListFragment.Component) : Presenter {

    @Inject
    lateinit var getArticleUseCase: GetArticleUseCase

    private val subscriptions = CompositeSubscription()
    private lateinit var articleFetcher: () -> Observable<List<Article>>
    private lateinit var paginationTrigger: PaginationHandler

    init {
        Flow.getAppComponent()
                .newPresentationComponent()
                .newArticleListComponent()
                .inject(this)
    }

    override fun onCreate() {
        articleFetcher = getArticleUseCase.getArticleFetcher(component)
        fragment.initialize()
        loadArticles(articleFetcher())
    }

    override fun onDestroy() {
        subscriptions.unsubscribe()
        paginationTrigger.unsubscribe()
    }

    override fun refresh() {
        articleFetcher = getArticleUseCase.getArticleFetcher(component)
        fragment.clearArticles()

        loadArticlesWithDelay()
    }

    fun registerPaginationTrigger(recyclerView: RecyclerView, manager: LinearLayoutManager) {
        paginationTrigger = PaginationHandler(recyclerView, manager)
        subscriptions.add(paginationTrigger.trigger().subscribe { loadArticles(articleFetcher()) })
    }

    fun loadArticles(observable: Observable<List<Article>>) {
        subscriptions.add(observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    fragment.showProgressBar()
                    paginationTrigger.unsubscribe()
                }
                .doAfterTerminate {
                    fragment.hideProgressBar()
                    paginationTrigger.subscribe()
                }
                .subscribe({
                    fragment.addArticles(it)
                }, {
                    ErrorHandler.handle(it)
                }))
    }

    fun loadArticlesWithDelay() {
        val observable = Observable.zip(
                Observable.timer(500, TimeUnit.MILLISECONDS),
                articleFetcher(),
                { delayMs, articles -> articles })

        loadArticles(observable)
    }

}