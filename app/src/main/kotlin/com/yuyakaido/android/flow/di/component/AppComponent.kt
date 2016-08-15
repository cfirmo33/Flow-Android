package com.yuyakaido.android.flow.di.component

import com.yuyakaido.android.flow.di.module.AppModule
import com.yuyakaido.android.flow.presentation.di.PresentationComponent
import dagger.Component
import javax.inject.Singleton

/**
 * Created by yuyakaido on 7/30/16.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun newPresentationComponent(): PresentationComponent
}
