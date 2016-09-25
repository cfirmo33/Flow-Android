package com.yuyakaido.android.flow.di.component

import com.yuyakaido.android.flow.di.scope.ViewModelScope
import com.yuyakaido.android.flow.presentation.fragment.QiitaPostFragment
import dagger.Subcomponent

/**
 * Created by yuyakaido on 9/25/16.
 */
@ViewModelScope
@Subcomponent
interface QiitaPostComponent {
    fun inject(fragment: QiitaPostFragment)
}