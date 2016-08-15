package com.yuyakaido.android.flow.presentation.di

import com.yuyakaido.android.flow.di.module.GetQiitaTagModule
import com.yuyakaido.android.flow.di.module.PutQiitaTagModule
import com.yuyakaido.android.flow.di.scope.PresentationScope
import com.yuyakaido.android.flow.presentation.presenter.QiitaTagPresenter
import dagger.Subcomponent

/**
 * Created by yuyakaido on 8/15/16.
 */
@PresentationScope
@Subcomponent(modules = arrayOf(
        GetQiitaTagModule::class,
        PutQiitaTagModule::class))
interface QiitaTagComponent {
    fun inject(qiitaTagPresenter: QiitaTagPresenter)
}
