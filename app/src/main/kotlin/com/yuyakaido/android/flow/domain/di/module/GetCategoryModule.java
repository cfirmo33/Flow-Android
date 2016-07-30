package com.yuyakaido.android.flow.domain.di.module;

import android.content.Context;

import com.yuyakaido.android.flow.di.module.MenthasModule;
import com.yuyakaido.android.flow.domain.usecase.GetCategoryUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yuyakaido on 7/30/16.
 */
@Module(includes = {MenthasModule.class})
public class GetCategoryModule {

    @Provides
    public GetCategoryUseCase provideGetCategoryUseCase(Context context) {
        return new GetCategoryUseCase(context);
    }

}
