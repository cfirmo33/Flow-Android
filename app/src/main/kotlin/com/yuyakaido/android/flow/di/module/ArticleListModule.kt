package com.yuyakaido.android.flow.di.module

import com.yuyakaido.android.flow.presentation.fragment.ArticleListFragment
import dagger.Module
import dagger.Provides

/**
 * Created by yuyakaido on 9/25/16.
 */
@Module
class ArticleListModule(private val component: ArticleListFragment.Component) {

    @Provides
    fun provideComponent(): ArticleListFragment.Component {
        return component
    }

}