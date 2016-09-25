package com.yuyakaido.android.flow.di.module

import com.yuyakaido.android.flow.infra.dao.OrmaBridge
import com.yuyakaido.android.flow.infra.dao.QiitaDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by yuyakaido on 9/24/16.
 */
@Module
class DaoModule {

    @Singleton
    @Provides
    fun provideQiitaDao(ormaBridge: OrmaBridge): QiitaDao {
        return QiitaDao(ormaBridge.orma)
    }

}