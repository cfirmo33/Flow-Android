package com.yuyakaido.android.flow.presentation.di;

import com.yuyakaido.android.flow.di.scope.PresentationScope;

import dagger.Subcomponent;

/**
 * Created by yuyakaido on 7/30/16.
 */
@PresentationScope
@Subcomponent
public interface PresentationComponent {
    ArticleListComponent newArticleListComponent();
}
