package com.yuyakaido.android.flow.di.module

import com.yuyakaido.android.flow.infra.api.client.HatenaApi
import com.yuyakaido.android.flow.infra.api.client.HatenaClient
import com.yuyakaido.android.flow.infra.api.common.ApiClientGenerator
import com.yuyakaido.android.flow.infra.constant.InfraConst
import com.yuyakaido.android.flow.infra.repository.HatenaRepository

import dagger.Module
import dagger.Provides

/**
 * Created by yuyakaido on 8/2/16.
 */
@Module
class HatenaModule {

    @Provides
    fun provideHatenaRepository(client: HatenaClient): HatenaRepository {
        return HatenaRepository(client)
    }

    @Provides
    fun provideHatenaClient(api: HatenaApi): HatenaClient {
        return HatenaClient(api)
    }

    @Provides
    fun provideHatenaApi(): HatenaApi {
        return ApiClientGenerator.createXmlClient(HatenaApi::class.java, InfraConst.HATENA_BASE_URL)
    }

}
