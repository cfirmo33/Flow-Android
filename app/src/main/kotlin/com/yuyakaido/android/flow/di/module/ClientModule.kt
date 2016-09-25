package com.yuyakaido.android.flow.di.module

import com.yuyakaido.android.flow.infra.api.client.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by yuyakaido on 9/24/16.
 */
@Module
class ClientModule {

    @Singleton
    @Provides
    fun provideMenthasClient(api: MenthasApi): MenthasClient {
        return MenthasClient(api)
    }

    @Singleton
    @Provides
    fun provideQiitaClient(api: QiitaApi): QiitaClient {
        return QiitaClient(api)
    }

    @Singleton
    @Provides
    fun provideHatenaClient(api: HatenaApi): HatenaClient {
        return HatenaClient(api)
    }

}