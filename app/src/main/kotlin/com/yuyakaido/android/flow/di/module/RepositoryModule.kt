package com.yuyakaido.android.flow.di.module

import com.yuyakaido.android.flow.infra.api.client.HatenaClient
import com.yuyakaido.android.flow.infra.api.client.MenthasClient
import com.yuyakaido.android.flow.infra.api.client.QiitaClient
import com.yuyakaido.android.flow.infra.dao.QiitaDao
import com.yuyakaido.android.flow.infra.repository.HatenaRepository
import com.yuyakaido.android.flow.infra.repository.MenthasRepository
import com.yuyakaido.android.flow.infra.repository.QiitaRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by yuyakaido on 9/24/16.
 */
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMenthasRepository(client: MenthasClient): MenthasRepository {
        return MenthasRepository(client)
    }

    @Singleton
    @Provides
    fun provideQiitaRepository(client: QiitaClient, dao: QiitaDao): QiitaRepository {
        return QiitaRepository(client, dao)
    }

    @Singleton
    @Provides
    fun provideHatenaRepository(client: HatenaClient): HatenaRepository {
        return HatenaRepository(client)
    }

}