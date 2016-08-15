package com.yuyakaido.android.flow.di.module

import com.yuyakaido.android.flow.domain.usecase.GetQiitaSubscriptionUseCase
import com.yuyakaido.android.flow.infra.repository.QiitaRepository
import dagger.Module
import dagger.Provides

/**
 * Created by yuyakaido on 8/15/16.
 */
@Module(includes = arrayOf(QiitaModule::class))
class GetQiitaSubscriptionModule {

    @Provides
    fun provideGetQiitaSubscriptionUseCase(repository: QiitaRepository): GetQiitaSubscriptionUseCase {
        return GetQiitaSubscriptionUseCase(repository)
    }

}