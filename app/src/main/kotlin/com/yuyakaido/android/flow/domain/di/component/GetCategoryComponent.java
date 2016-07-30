package com.yuyakaido.android.flow.domain.di.component;

import com.yuyakaido.android.flow.di.scope.DomainScope;
import com.yuyakaido.android.flow.domain.di.module.GetCategoryModule;
import com.yuyakaido.android.flow.domain.usecase.GetCategoryUseCase;

import dagger.Subcomponent;

/**
 * Created by yuyakaido on 7/30/16.
 */
@DomainScope
@Subcomponent(modules = {GetCategoryModule.class})
public interface GetCategoryComponent {
    void inject(GetCategoryUseCase getCategoryUseCase);
}
