package com.yuyakaido.android.flow.app

import android.app.Application
import android.content.Context
import com.yuyakaido.android.flow.di.component.AppComponent
import com.yuyakaido.android.flow.di.component.ComponentUtil

/**
 * Created by yuyakaido on 7/30/16.
 */
open class Flow : Application() {

    companion object {

        fun getAppComponent(context: Context): AppComponent {
            return (context.applicationContext as Flow).appComponent
        }

    }

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    open fun initializeDagger() {
        appComponent = ComponentUtil.get()
    }

}