package com.yuyakaido.android.flow.domain.di.component;

import com.yuyakaido.android.flow.di.scope.DomainScope;

import dagger.Subcomponent;

/**
 * Created by yuyakaido on 7/30/16.
 */
@DomainScope
@Subcomponent
public interface DomainComponent {
    GetArticleComponent newGetArticleComponent();
    GetCategoryComponent newGetCategoryComponent();
}
