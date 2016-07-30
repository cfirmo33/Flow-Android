package com.yuyakaido.android.flow.presentation.di;

import com.yuyakaido.android.flow.di.scope.PresentationScope;
import com.yuyakaido.android.flow.domain.di.module.GetCategoryModule;
import com.yuyakaido.android.flow.presentation.fragment.MenthasFragment;

import dagger.Subcomponent;

/**
 * Created by yuyakaido on 7/30/16.
 */
@PresentationScope
@Subcomponent(modules = {GetCategoryModule.class})
public interface MenthasCategoryComponent {
    void inject(MenthasFragment menthasFragment);
}
