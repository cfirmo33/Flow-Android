package com.yuyakaido.android.flow.presentation.presenter

import com.yuyakaido.android.flow.app.Flow
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.domain.entity.Site
import com.yuyakaido.android.flow.domain.usecase.GetArticleUseCase
import com.yuyakaido.android.flow.presentation.fragment.ArticleListFragment
import com.yuyakaido.android.flow.util.ErrorHandler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

/**
 * Created by yuyakaido on 7/31/16.
 */
class ArticleListPresenter(val fragment: ArticleListFragment, val site: Site, val category: Category) : Presenter {

    private val subscriptions = CompositeSubscription()

    @Inject
    lateinit var getArticleUseCase: GetArticleUseCase

    init {
        Flow.getAppComponent(fragment.context)
                .newPresentationComponent()
                .newArticleListComponent()
                .inject(this)
    }

    override fun onCreate() {
        fragment.initialize()
        refresh()
    }

    override fun onDestroy() {
        subscriptions.unsubscribe()
    }

    override fun refresh() {
        subscriptions.add(getArticleUseCase.getArticles(site, category)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { fragment.addArticles(it) },
                        { ErrorHandler.handle(it) }))
    }

}