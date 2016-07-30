package com.yuyakaido.android.flow.di.component;

/**
 * Created by yuyakaido on 7/30/16.
 * Workaround for http://www.slideshare.net/shinnosukekugimiya/kotlin-qiitlin
 */
public class ComponentUtil {

    public static AppComponent get() {
        return DaggerAppComponent.builder().build();
    }

}
