package com.yuyakaido.android.flow.di.component;

import com.yuyakaido.android.flow.di.module.AppModule;
import com.yuyakaido.android.flow.di.module.MenthasModule;
import com.yuyakaido.android.flow.domain.di.DomainComponent;
import com.yuyakaido.android.flow.presentation.di.PresentationComponent;
import com.yuyakaido.android.flow.presentation.fragment.MenthasFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by yuyakaido on 7/30/16.
 */
@Singleton
@Component(modules = {
        AppModule.class,
        MenthasModule.class})
public interface AppComponent {
    void inject(MenthasFragment menthasFragment);

    DomainComponent newDomainComponent();
    PresentationComponent newPresentationComponent();
}
