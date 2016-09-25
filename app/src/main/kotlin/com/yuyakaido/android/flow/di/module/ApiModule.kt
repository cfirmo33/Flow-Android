package com.yuyakaido.android.flow.di.module

import com.yuyakaido.android.flow.infra.api.client.HatenaApi
import com.yuyakaido.android.flow.infra.api.client.MenthasApi
import com.yuyakaido.android.flow.infra.api.client.QiitaApi
import com.yuyakaido.android.flow.infra.api.common.ApiClientGenerator
import com.yuyakaido.android.flow.infra.constant.InfraConst
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by yuyakaido on 9/24/16.
 */
@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideMenthasApi(): MenthasApi {
        return ApiClientGenerator.createJsonClient(MenthasApi::class.java, InfraConst.MENTHAS_BASE_URL)
    }

    @Singleton
    @Provides
    fun provideQiitaApi(): QiitaApi {
        return ApiClientGenerator.createJsonClient(QiitaApi::class.java, InfraConst.QIITA_BASE_URL)
    }

    @Singleton
    @Provides
    fun provideHatenaApi(): HatenaApi {
        return ApiClientGenerator.createXmlClient(HatenaApi::class.java, InfraConst.HATENA_BASE_URL)
    }

}