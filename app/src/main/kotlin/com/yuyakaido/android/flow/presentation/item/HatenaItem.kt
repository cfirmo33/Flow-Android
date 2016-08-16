package com.yuyakaido.android.flow.presentation.item

import android.support.v4.app.Fragment
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.domain.entity.Site
import com.yuyakaido.android.flow.presentation.fragment.CategoryPagerFragment

/**
 * Created by yuyakaido on 8/16/16.
 */
enum class HatenaItem(val titleResId: Int) {
    Hot(R.string.hatena_hot) {
        override fun fragment() = CategoryPagerFragment.newInstance(Site.HatenaHot)
    },
    New(R.string.hatena_new) {
        override fun fragment() = CategoryPagerFragment.newInstance(Site.HatenaNew)
    };

    abstract fun fragment(): Fragment
}