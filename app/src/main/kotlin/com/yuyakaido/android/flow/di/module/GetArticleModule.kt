package com.yuyakaido.android.flow.di.module

import com.yuyakaido.android.flow.domain.usecase.GetArticleUseCase
import com.yuyakaido.android.flow.infra.repository.HatenaRepository
import com.yuyakaido.android.flow.infra.repository.MenthasRepository
import com.yuyakaido.android.flow.infra.repository.QiitaRepository

import dagger.Module
import dagger.Provides

/**
 * Created by yuyakaido on 8/3/16.
 */
@Module(includes = arrayOf(
        MenthasModule::class,
        QiitaModule::class,
        HatenaModule::class))
class GetArticleModule {

    @Provides
    fun provideGetArticlesUseCase(
            menthasRepository: MenthasRepository,
            qiitaRepository: QiitaRepository,
            hatenaRepository: HatenaRepository): GetArticleUseCase {
        return GetArticleUseCase(menthasRepository, qiitaRepository, hatenaRepository)
    }

}
