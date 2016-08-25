package com.yuyakaido.android.flow.presentation.presenter

import com.yuyakaido.android.flow.app.Flow
import com.yuyakaido.android.flow.domain.entity.QiitaTag
import com.yuyakaido.android.flow.domain.usecase.GetQiitaTagUseCase
import com.yuyakaido.android.flow.domain.usecase.PutQiitaTagUseCase
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

    @Inject
    lateinit var putQiitaTagUseCase: PutQiitaTagUseCase

    init {
        Flow.getAppComponent().newPresentationComponent().inject(this)
    }

    override fun onCreate() {
        fragment.initialize()
        refresh()
    }

    override fun onDestroy() {
        subscriptions.unsubscribe()
    }

    override fun refresh() {
        subscriptions.add(getQiitaTagUseCase.getQiitaTags()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { fragment.showProgressBar() }
                .doOnSuccess { fragment.hideProgressBar() }
                .doOnError { fragment.hideProgressBar() }
                .subscribe({
                    fragment.addQiitaTags(it)
                }, {
                    ErrorHandler.handle(it)
                }))
    }

    fun onCheckChanged(tag: QiitaTag) {
        tag.subscribed = !tag.subscribed

        subscriptions.add(putQiitaTagUseCase.putQiitaTag(tag)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    // TODO Show notification
                }, {
                    ErrorHandler.handle(it)
                }))
    }

}