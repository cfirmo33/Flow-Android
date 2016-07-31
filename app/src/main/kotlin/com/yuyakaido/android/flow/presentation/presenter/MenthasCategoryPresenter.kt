package com.yuyakaido.android.flow.presentation.presenter

import com.yuyakaido.android.flow.app.Flow
import com.yuyakaido.android.flow.domain.usecase.GetCategoryUseCase
import com.yuyakaido.android.flow.presentation.fragment.MenthasCategoryFragment
import com.yuyakaido.android.flow.util.ErrorHandler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

/**
 * Created by yuyakaido on 7/31/16.
 */
class MenthasCategoryPresenter(val fragment: MenthasCategoryFragment) : Presenter {

    private val subscriptions = CompositeSubscription()

    @Inject
    lateinit var getCategoryUseCase: GetCategoryUseCase

    init {
        Flow.getAppComponent(fragment.context)
                .newPresentationComponent()
                .newMenthasCategoryComponent()
                .inject(this)
    }

    override fun onCreate() {
        refresh()
    }

    override fun onDestroy() {
        subscriptions.unsubscribe()
    }

    override fun refresh() {
        subscriptions.add(getCategoryUseCase.getCategories()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { fragment.setCategories(it) },
                        { ErrorHandler.handle(it) }))
    }

}