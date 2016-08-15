package com.yuyakaido.android.flow.di.module

import com.yuyakaido.android.flow.infra.api.client.QiitaApi
import com.yuyakaido.android.flow.infra.api.client.QiitaClient
import com.yuyakaido.android.flow.infra.api.common.ApiClientGenerator
import com.yuyakaido.android.flow.infra.constant.InfraConst
import com.yuyakaido.android.flow.infra.repository.QiitaRepository

import dagger.Module
import dagger.Provides

/**
 * Created by yuyakaido on 7/30/16.
 */
@Module
class QiitaModule {

    @Provides
    fun provideQiitaRepository(client: QiitaClient): QiitaRepository {
        return QiitaRepository(client)
    }

    @Provides
    fun provideQiitaClient(api: QiitaApi): QiitaClient {
        return QiitaClient(api)
    }

    @Provides
    fun provideQiitaApi(): QiitaApi {
        return ApiClientGenerator.createJsonClient(QiitaApi::class.java, InfraConst.QIITA_BASE_URL)
    }

}
