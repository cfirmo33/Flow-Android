package com.yuyakaido.android.flow.presentation.di;

import com.yuyakaido.android.flow.di.module.MenthasModule;
import com.yuyakaido.android.flow.di.scope.PresentationScope;
import com.yuyakaido.android.flow.presentation.fragment.MenthasCategoryFragment;

import dagger.Subcomponent;

/**
 * Created by yuyakaido on 7/30/16.
 */
@PresentationScope
@Subcomponent(modules = {MenthasModule.class})
public interface MenthasCategoryComponent {
    void inject(MenthasCategoryFragment menthasCategoryFragment);
}
