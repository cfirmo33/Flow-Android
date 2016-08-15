package com.yuyakaido.android.flow.presentation.presenter

import com.yuyakaido.android.flow.app.Flow
import com.yuyakaido.android.flow.domain.usecase.GetQiitaSubscriptionUseCase
import com.yuyakaido.android.flow.presentation.fragment.QiitaPostFragment
import com.yuyakaido.android.flow.util.ErrorHandler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

/**
 * Created by yuyakaido on 8/15/16.
 */
class QiitaPostPresenter(val fragment: QiitaPostFragment) : Presenter {

    private val subscriptions = CompositeSubscription()

    @Inject
    lateinit var getQiitaSubscriptionUseCase: GetQiitaSubscriptionUseCase

    init {
        Flow.getAppComponent(fragment.context)
                .newPresentationComponent()
                .newQiitaPostComponent()
                .inject(this)
    }

    override fun onCreate() {
        refresh()
    }

    override fun onDestroy() {
        subscriptions.unsubscribe()
    }

    override fun refresh() {
        subscriptions.add(getQiitaSubscriptionUseCase.getQiitaSubscriptions()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { fragment.showProgressBar() }
                .doOnSuccess { fragment.hideProgressBar() }
                .doOnError { fragment.hideProgressBar()}
                .subscribe(
                        { fragment.setQiitaSubscriptions(it) },
                        { ErrorHandler.handle(it) }))
    }

}