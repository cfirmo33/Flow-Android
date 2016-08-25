package com.yuyakaido.android.flow.presentation.di

import com.yuyakaido.android.flow.di.scope.PresentationScope
import com.yuyakaido.android.flow.presentation.presenter.ArticleListPresenter
import com.yuyakaido.android.flow.presentation.presenter.CategoryPagerPresenter
import com.yuyakaido.android.flow.presentation.presenter.QiitaPostPresenter
import com.yuyakaido.android.flow.presentation.presenter.QiitaTagPresenter

import dagger.Subcomponent

/**
 * Created by yuyakaido on 7/30/16.
 */
@PresentationScope
@Subcomponent
interface PresentationComponent {
    fun inject(articleListPresenter: ArticleListPresenter)
    fun inject(categoryPagerPresenter: CategoryPagerPresenter)
    fun inject(qiitaPostPresenter: QiitaPostPresenter)
    fun inject(qiitaTagPresenter: QiitaTagPresenter)
}
