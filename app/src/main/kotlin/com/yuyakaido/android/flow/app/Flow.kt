package com.yuyakaido.android.flow.app

import android.app.Application
import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.facebook.stetho.Stetho
import com.yuyakaido.android.flow.di.component.AppComponent
import com.yuyakaido.android.flow.di.component.DaggerAppComponent
import com.yuyakaido.android.flow.di.module.AppModule
import com.yuyakaido.android.flow.infra.api.common.HttpClient
import java.io.InputStream

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
        initializeStetho()
    }

    open fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    open fun initializeStetho() {
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build())
        Glide.get(this).register(GlideUrl::class.java, InputStream::class.java,
                OkHttpUrlLoader.Factory(HttpClient.httpClient))
    }

}