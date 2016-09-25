package com.yuyakaido.android.flow.di.component

import com.yuyakaido.android.flow.di.module.GetCategoryModule
import com.yuyakaido.android.flow.di.scope.PresentationScope
import com.yuyakaido.android.flow.presentation.fragment.CategoryPagerFragment
import dagger.Subcomponent

/**
 * Created by yuyakaido on 9/24/16.
 */
@PresentationScope
@Subcomponent(modules = arrayOf(GetCategoryModule::class))
interface CategoryPagerComponent {
    fun inject(fragment: CategoryPagerFragment)
}