package com.yuyakaido.android.flow.di.module

import com.yuyakaido.android.flow.domain.usecase.GetQiitaTagUseCase
import com.yuyakaido.android.flow.infra.repository.QiitaRepository

import dagger.Module
import dagger.Provides

/**
 * Created by yuyakaido on 8/15/16.
 */
@Module
class GetQiitaTagModule {

    @Provides
    fun provideGetQiitaTagUseCase(repository: QiitaRepository): GetQiitaTagUseCase {
        return GetQiitaTagUseCase(repository)
    }

}
