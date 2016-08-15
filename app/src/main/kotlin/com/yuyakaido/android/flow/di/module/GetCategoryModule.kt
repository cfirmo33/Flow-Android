package com.yuyakaido.android.flow.di.module

import com.yuyakaido.android.flow.domain.usecase.GetCategoryUseCase
import com.yuyakaido.android.flow.infra.repository.MenthasRepository

import dagger.Module
import dagger.Provides

/**
 * Created by yuyakaido on 8/3/16.
 */
@Module(includes = arrayOf(MenthasModule::class))
class GetCategoryModule {

    @Provides
    fun provideGetCategoryUseCase(menthasRepository: MenthasRepository): GetCategoryUseCase {
        return GetCategoryUseCase(menthasRepository)
    }

}
