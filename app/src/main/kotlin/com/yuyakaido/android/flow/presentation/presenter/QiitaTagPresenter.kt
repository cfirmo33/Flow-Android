package com.yuyakaido.android.flow.presentation.presenter

import com.yuyakaido.android.flow.app.Flow
import com.yuyakaido.android.flow.domain.usecase.GetQiitaTagUseCase
import com.yuyakaido.android.flow.presentation.fragment.QiitaTagFragment
import com.yuyakaido.android.flow.util.ErrorHandler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

/**
 * Created by yuyakaido on 8/15/16.
 */
class QiitaTagPresenter(private val fragment: QiitaTagFragment) : Presenter {

    private val subscriptions = CompositeSubscription()

    @Inject
    lateinit var getQiitaTagUseCase: GetQiitaTagUseCase

    init {
        Flow.getAppComponent(fragment.context)
                .newPresentationComponent()
                .newQiitaTagComponent()
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
        subscriptions.add(getQiitaTagUseCase.getTags()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { fragment.addTags(it) },
                        { ErrorHandler.handle(it) }))
    }

}