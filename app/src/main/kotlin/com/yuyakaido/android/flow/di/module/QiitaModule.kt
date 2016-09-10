package com.yuyakaido.android.flow.di.module

import com.yuyakaido.android.flow.infra.api.client.QiitaApi
import com.yuyakaido.android.flow.infra.api.client.QiitaClient
import com.yuyakaido.android.flow.infra.api.common.ApiClientGenerator
import com.yuyakaido.android.flow.infra.constant.InfraConst
import com.yuyakaido.android.flow.infra.dao.OrmaBridge
import com.yuyakaido.android.flow.infra.dao.QiitaDao
import com.yuyakaido.android.flow.infra.repository.QiitaRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by yuyakaido on 7/30/16.
 */
@Module
class QiitaModule {

    @Singleton
    @Provides
    fun provideQiitaRepository(client: QiitaClient, dao: QiitaDao): QiitaRepository {
        return QiitaRepository(client, dao)
    }

    @Singleton
    @Provides
    fun provideQiitaClient(api: QiitaApi): QiitaClient {
        return QiitaClient(api)
    }

    @Singleton
    @Provides
    fun provideQiitaApi(): QiitaApi {
        return ApiClientGenerator.createJsonClient(QiitaApi::class.java, InfraConst.QIITA_BASE_URL)
    }

    @Singleton
    @Provides
    fun provideQiitaDao(ormaBridge: OrmaBridge): QiitaDao {
        return QiitaDao(ormaBridge.orma)
    }

}
