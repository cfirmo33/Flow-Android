package com.yuyakaido.android.flow.presentation.viewmodel

import com.yuyakaido.android.flow.domain.entity.QiitaTag
import com.yuyakaido.android.flow.domain.usecase.GetQiitaTagUseCase
import com.yuyakaido.android.flow.domain.usecase.PutQiitaTagUseCase
import com.yuyakaido.android.flow.util.ErrorHandler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subjects.PublishSubject
import javax.inject.Inject

/**
 * Created by yuyakaido on 8/15/16.
 */
class QiitaTagViewModel @Inject constructor(
        getQiitaTagUseCase: GetQiitaTagUseCase,
        putQiitaTagUseCase: PutQiitaTagUseCase) : ViewModel {

    val tags = getQiitaTagUseCase.getQiitaTags()
    val putTrigger = PublishSubject.create<QiitaTag>()

    init {
        putTrigger
                .flatMap {
                    it.subscribed = !it.subscribed
                    putQiitaTagUseCase.putQiitaTag(it).subscribeOn(Schedulers.io()).toObservable()
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    // Do nothing
                }, {
                    ErrorHandler.handle(it)
                })
    }

}