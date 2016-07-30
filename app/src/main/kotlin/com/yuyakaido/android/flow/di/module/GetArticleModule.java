package com.yuyakaido.android.flow.di.module;

import android.content.Context;

import com.yuyakaido.android.flow.domain.usecase.GetArticleUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yuyakaido on 7/30/16.
 */
@Module(includes = {
        MenthasModule.class,
        QiitaModule.class})
public class GetArticleModule {

    @Provides
    public GetArticleUseCase provideGetArticlesUseCase(Context context) {
        return new GetArticleUseCase(context);
    }

}
