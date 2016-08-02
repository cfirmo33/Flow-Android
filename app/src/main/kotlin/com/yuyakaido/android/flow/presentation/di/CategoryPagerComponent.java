package com.yuyakaido.android.flow.presentation.di;

import com.yuyakaido.android.flow.di.module.GetCategoryModule;
import com.yuyakaido.android.flow.di.module.MenthasModule;
import com.yuyakaido.android.flow.di.scope.PresentationScope;
import com.yuyakaido.android.flow.presentation.presenter.CategoryPagerPresenter;

import dagger.Subcomponent;

/**
 * Created by yuyakaido on 7/30/16.
 */
@PresentationScope
@Subcomponent(modules = {
        MenthasModule.class,
        GetCategoryModule.class})
public interface CategoryPagerComponent {
    void inject(CategoryPagerPresenter categoryPagerPresenter);
}
