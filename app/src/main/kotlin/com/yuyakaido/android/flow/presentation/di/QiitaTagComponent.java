package com.yuyakaido.android.flow.presentation.di;

import com.yuyakaido.android.flow.di.module.GetQiitaTagModule;
import com.yuyakaido.android.flow.di.module.QiitaModule;
import com.yuyakaido.android.flow.di.scope.PresentationScope;
import com.yuyakaido.android.flow.presentation.presenter.QiitaTagPresenter;

import dagger.Subcomponent;

/**
 * Created by yuyakaido on 8/15/16.
 */
@PresentationScope
@Subcomponent(modules = {
        QiitaModule.class,
        GetQiitaTagModule.class})
public interface QiitaTagComponent {
    void inject(QiitaTagPresenter qiitaTagPresenter);
}
