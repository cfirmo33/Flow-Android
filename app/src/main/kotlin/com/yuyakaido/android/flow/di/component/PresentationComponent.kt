package com.yuyakaido.android.flow.di.component

import com.yuyakaido.android.flow.di.scope.PresentationScope
import com.yuyakaido.android.flow.presentation.presenter.ArticleListPresenter
import com.yuyakaido.android.flow.presentation.presenter.QiitaPostPresenter
import com.yuyakaido.android.flow.presentation.viewmodel.QiitaTagViewModel
import dagger.Subcomponent

/**
 * Created by yuyakaido on 7/30/16.
 */
@PresentationScope
@Subcomponent
interface PresentationComponent {
    fun inject(articleListPresenter: ArticleListPresenter)
    fun inject(qiitaPostPresenter: QiitaPostPresenter)
    fun inject(qiitaTagViewModel: QiitaTagViewModel)
}
