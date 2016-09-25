package com.yuyakaido.android.flow.di.module

import com.yuyakaido.android.flow.domain.usecase.GetCategoryUseCase
import com.yuyakaido.android.flow.infra.repository.HatenaRepository
import com.yuyakaido.android.flow.infra.repository.MenthasRepository
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

}