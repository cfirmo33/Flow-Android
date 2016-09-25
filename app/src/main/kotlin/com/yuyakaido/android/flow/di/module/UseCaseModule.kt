package com.yuyakaido.android.flow.di.module

import com.yuyakaido.android.flow.domain.usecase.GetCategoryUseCase
import com.yuyakaido.android.flow.domain.usecase.GetQiitaSubscriptionUseCase
import com.yuyakaido.android.flow.domain.usecase.GetQiitaTagUseCase
import com.yuyakaido.android.flow.domain.usecase.PutQiitaTagUseCase
import com.yuyakaido.android.flow.infra.repository.HatenaRepository
import com.yuyakaido.android.flow.infra.repository.MenthasRepository
import com.yuyakaido.android.flow.infra.repository.QiitaRepository
import dagger.Module
import dagger.Provides

/**
 * Created by yuyakaido on 9/24/16.
 */
@Module
class UseCaseModule {

    @Provides
    fun provideGetCategoryUseCase(
            menthasRepository: MenthasRepository,
            hatenaRepository: HatenaRepository): GetCategoryUseCase {
        return GetCategoryUseCase(menthasRepository, hatenaRepository)
    }

    @Provides
    fun provideGetQiitaTagUseCase(qiitaRepository: QiitaRepository): GetQiitaTagUseCase {
        return GetQiitaTagUseCase(qiitaRepository)
    }

    @Provides
    fun providePutQiitaTagUseCase(qiitaRepository: QiitaRepository): PutQiitaTagUseCase {
        return PutQiitaTagUseCase(qiitaRepository)
    }

    @Provides
    fun provideGetQiitaSubscriptionUseCase(qiitaRepository: QiitaRepository): GetQiitaSubscriptionUseCase {
        return GetQiitaSubscriptionUseCase(qiitaRepository)
    }

}