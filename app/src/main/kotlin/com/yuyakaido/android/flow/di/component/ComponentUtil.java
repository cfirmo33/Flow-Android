package com.yuyakaido.android.flow.di.component;

import android.app.Application;

import com.yuyakaido.android.flow.di.module.AppModule;

/**
 * Created by yuyakaido on 7/30/16.
 * Workaround for http://www.slideshare.net/shinnosukekugimiya/kotlin-qiitlin
 */
public class ComponentUtil {

    public static AppComponent get(Application application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }

}
