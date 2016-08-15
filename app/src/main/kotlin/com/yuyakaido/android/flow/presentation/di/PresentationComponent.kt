package com.yuyakaido.android.flow.presentation.di

import com.yuyakaido.android.flow.di.scope.PresentationScope

import dagger.Subcomponent

/**
 * Created by yuyakaido on 7/30/16.
 */
@PresentationScope
@Subcomponent
interface PresentationComponent {
    fun newCategoryPagerComponent(): CategoryPagerComponent
    fun newArticleListComponent(): ArticleListComponent
    fun newQiitaTagComponent(): QiitaTagComponent
    fun newQiitaPostComponent(): QiitaPostComponent
}
