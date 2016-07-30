package com.yuyakaido.android.flow.presentation.di;

import com.yuyakaido.android.flow.domain.di.module.GetArticleModule;
import com.yuyakaido.android.flow.di.scope.ModuleScope;
import com.yuyakaido.android.flow.presentation.fragment.ArticleListFragment;

import dagger.Subcomponent;

/**
 * Created by yuyakaido on 7/30/16.
 */
@ModuleScope
@Subcomponent(modules = {GetArticleModule.class})
public interface ArticleListComponent {
    void inject(ArticleListFragment articleListFragment);
}
