package com.yuyakaido.android.flow.presentation.di

import com.yuyakaido.android.flow.di.module.GetArticleModule
import com.yuyakaido.android.flow.di.scope.PresentationScope
import com.yuyakaido.android.flow.presentation.presenter.ArticleListPresenter
import dagger.Subcomponent

/**
 * Created by yuyakaido on 7/30/16.
 */
@PresentationScope
@Subcomponent(modules = arrayOf(GetArticleModule::class))
interface ArticleListComponent {
    fun inject(articleListPresenter: ArticleListPresenter)
}
