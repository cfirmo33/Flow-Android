package com.yuyakaido.android.flow.presentation.di

import com.yuyakaido.android.flow.di.module.GetCategoryModule
import com.yuyakaido.android.flow.di.scope.PresentationScope
import com.yuyakaido.android.flow.presentation.presenter.CategoryPagerPresenter
import dagger.Subcomponent

/**
 * Created by yuyakaido on 7/30/16.
 */
@PresentationScope
@Subcomponent(modules = arrayOf(GetCategoryModule::class))
interface CategoryPagerComponent {
    fun inject(categoryPagerPresenter: CategoryPagerPresenter)
}
