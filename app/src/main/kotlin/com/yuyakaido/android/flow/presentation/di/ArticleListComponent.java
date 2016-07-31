package com.yuyakaido.android.flow.presentation.di;

import com.yuyakaido.android.flow.di.module.MenthasModule;
import com.yuyakaido.android.flow.di.module.QiitaModule;
import com.yuyakaido.android.flow.di.scope.PresentationScope;
import com.yuyakaido.android.flow.presentation.presenter.ArticleListPresenter;

import dagger.Subcomponent;

/**
 * Created by yuyakaido on 7/30/16.
 */
@PresentationScope
@Subcomponent(modules = {
        MenthasModule.class,
        QiitaModule.class})
public interface ArticleListComponent {
    void inject(ArticleListPresenter articleListPresenter);
}
