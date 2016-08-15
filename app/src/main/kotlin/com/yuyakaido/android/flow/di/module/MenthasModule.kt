package com.yuyakaido.android.flow.di.module

import com.yuyakaido.android.flow.infra.api.client.MenthasApi
import com.yuyakaido.android.flow.infra.api.client.MenthasClient
import com.yuyakaido.android.flow.infra.api.common.ApiClientGenerator
import com.yuyakaido.android.flow.infra.constant.InfraConst
import com.yuyakaido.android.flow.infra.repository.MenthasRepository

import dagger.Module
import dagger.Provides

/**
 * Created by yuyakaido on 7/30/16.
 */
@Module
class MenthasModule {

    @Provides
    fun provideMenthasRepository(client: MenthasClient): MenthasRepository {
        return MenthasRepository(client)
    }

    @Provides
    fun provideMenthasClient(api: MenthasApi): MenthasClient {
        return MenthasClient(api)
    }

    @Provides
    fun provideMenthasApi(): MenthasApi {
        return ApiClientGenerator.createJsonClient(MenthasApi::class.java, InfraConst.MENTHAS_BASE_URL)
    }

}
