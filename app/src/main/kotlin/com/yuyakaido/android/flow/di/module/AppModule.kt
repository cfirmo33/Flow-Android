package com.yuyakaido.android.flow.di.module

import android.app.Application
import android.content.Context
import com.yuyakaido.android.flow.infra.dao.OrmaBridge
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by yuyakaido on 7/30/16.
 */
@Module(includes = arrayOf(ApiModule::class))
class AppModule(private val application: Application) {

    @Provides
    fun provideContext(): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideOrmaBridge(context: Context): OrmaBridge {
        return OrmaBridge(context)
    }

}
