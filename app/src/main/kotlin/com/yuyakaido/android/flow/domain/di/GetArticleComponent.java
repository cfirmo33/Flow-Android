package com.yuyakaido.android.flow.domain.di;

import com.yuyakaido.android.flow.di.module.GetArticleModule;
import com.yuyakaido.android.flow.di.scope.ModuleScope;
import com.yuyakaido.android.flow.domain.usecase.GetArticleUseCase;

import dagger.Subcomponent;

/**
 * Created by yuyakaido on 7/30/16.
 */
@ModuleScope
@Subcomponent(modules = {GetArticleModule.class})
public interface GetArticleComponent {
    void inject(GetArticleUseCase getArticleUseCase);
}
