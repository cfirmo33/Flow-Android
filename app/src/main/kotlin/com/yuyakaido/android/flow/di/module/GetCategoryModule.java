package com.yuyakaido.android.flow.di.module;

import com.yuyakaido.android.flow.domain.usecase.GetCategoryUseCase;
import com.yuyakaido.android.flow.infra.repository.MenthasRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yuyakaido on 8/3/16.
 */
@Module
public class GetCategoryModule {

    @Provides
    public GetCategoryUseCase provideGetCategoryUseCase(MenthasRepository menthasRepository) {
        return new GetCategoryUseCase(menthasRepository);
    }

}
