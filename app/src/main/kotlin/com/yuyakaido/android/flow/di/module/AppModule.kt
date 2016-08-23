package com.yuyakaido.android.flow.di.module

import android.app.Application
import android.content.Context
import com.github.gfx.android.orma.AccessThreadConstraint
import com.yuyakaido.android.flow.domain.entity.OrmaDatabase
import com.yuyakaido.android.flow.infra.dao.OrmaBridge
import dagger.Module
import dagger.Provides

/**
 * Created by yuyakaido on 7/30/16.
 */
@Module
class AppModule(private val application: Application) {

    @Provides
    fun provideContext(): Context {
        return application.applicationContext
    }

    @Provides
    fun provideOrmaBridge(context: Context): OrmaBridge {
        return OrmaBridge(OrmaDatabase.builder(context)
                .readOnMainThread(AccessThreadConstraint.FATAL)
                .writeOnMainThread(AccessThreadConstraint.FATAL)
                .build())
    }

}
