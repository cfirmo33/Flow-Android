package com.yuyakaido.android.flow.di.component;

import com.yuyakaido.android.flow.di.module.AppModule;
import com.yuyakaido.android.flow.presentation.di.PresentationComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by yuyakaido on 7/30/16.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    PresentationComponent newPresentationComponent();
}
