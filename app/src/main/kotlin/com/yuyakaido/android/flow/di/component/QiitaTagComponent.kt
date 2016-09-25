package com.yuyakaido.android.flow.di.component

import com.yuyakaido.android.flow.di.scope.PresentationScope
import com.yuyakaido.android.flow.presentation.fragment.QiitaTagFragment
import dagger.Subcomponent

/**
 * Created by yuyakaido on 9/25/16.
 */
@PresentationScope
@Subcomponent
interface QiitaTagComponent {
    fun inject(fragment: QiitaTagFragment)
}