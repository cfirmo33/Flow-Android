package com.yuyakaido.android.flow.presentation.viewmodel

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.jakewharton.rxbinding.support.v7.widget.scrollEvents
import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.usecase.GetArticleUseCase
import com.yuyakaido.android.flow.presentation.fragment.ArticleListFragment
import com.yuyakaido.android.flow.util.ErrorHandler
import com.yuyakaido.android.flow.util.RecyclerViewUtil
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subjects.BehaviorSubject
import rx.subjects.PublishSubject
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

/**
 * Created by yuyakaido on 7/31/16.
 */
class ArticleListViewModel @Inject constructor(
        private val getArticleUseCase: GetArticleUseCase,
        private val component: ArticleListFragment.Component) : ViewModel {

    private val subscriptions = CompositeSubscription()
    private var fetcher = getArticleUseCase.getArticleFetcher(component)
    private val initializationTrigger = BehaviorSubject.create<Void>()
    private val paginationTrigger = PublishSubject.create<Void>()

    val articles = BehaviorSubject.create<List<Article>>()
    val showProgressBar = PublishSubject.create<Boolean>()
    val refreshTrigger = PublishSubject.create<Void>()

    init {
        initializationTrigger.onNext(null)

        subscriptions.add(initializationTrigger
                .subscribe({
                    loadArticles()
                }, {
                    ErrorHandler.handle(it)
                }))

        subscriptions.add(paginationTrigger
                .subscribe({
                    loadArticles()
                }, {
                    ErrorHandler.handle(it)
                }))

        subscriptions.add(refreshTrigger
                .subscribe({
                    fetcher = getArticleUseCase.getArticleFetcher(component)
                    initializationTrigger.onNext(null)
                }, {
                    ErrorHandler.handle(it)
                }))
    }

    override fun onCreate() {
        // Do nothing
    }

    override fun onDestroy() {
        subscriptions.unsubscribe()
    }

    override fun onRefresh() {
        // Do nothing
    }

    fun loadArticles() {
        subscriptions.add(fetcher()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { showProgressBar.onNext(true) }
                .doOnUnsubscribe { showProgressBar.onNext(false) }
                .subscribe({
                    articles.onNext(it)
                }, {
                    ErrorHandler.handle(it)
                }))
    }

    fun registerPaginationTrigger(recyclerView: RecyclerView, layoutManager: LinearLayoutManager) {
        subscriptions.add(recyclerView.scrollEvents()
                .filter(RecyclerViewUtil.shouldPaginate(layoutManager))
                .subscribe({
                    paginationTrigger.onNext(null)
                }, {
                    ErrorHandler.handle(it)
                }))
    }

}