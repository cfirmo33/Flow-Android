package com.yuyakaido.android.flow.di.module

import com.yuyakaido.android.flow.domain.entity.Site
import dagger.Module
import dagger.Provides

/**
 * Created by yuyakaido on 9/24/16.
 */
@Module
class GetCategoryModule(private val site: Site) {

    @Provides
    fun provideSite(): Site {
        return site
    }

}