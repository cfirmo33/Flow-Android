package com.yuyakaido.android.flow.di.component

import com.yuyakaido.android.flow.di.module.ArticleListModule
import com.yuyakaido.android.flow.di.scope.PresentationScope
import com.yuyakaido.android.flow.presentation.fragment.ArticleListFragment
import dagger.Subcomponent

/**
 * Created by yuyakaido on 9/25/16.
 */
@PresentationScope
@Subcomponent(modules = arrayOf(ArticleListModule::class))
interface ArticleListComponent {
    fun inject(fragment: ArticleListFragment)
}