package com.yuyakaido.android.flow.presentation.di

import com.yuyakaido.android.flow.di.module.GetQiitaSubscriptionModule
import com.yuyakaido.android.flow.di.scope.PresentationScope
import com.yuyakaido.android.flow.presentation.presenter.QiitaPostPresenter
import dagger.Subcomponent

/**
 * Created by yuyakaido on 8/15/16.
 */
@PresentationScope
@Subcomponent(modules = arrayOf(GetQiitaSubscriptionModule::class))
interface QiitaPostComponent {
    fun inject(qiitaPostPresenter: QiitaPostPresenter)
}