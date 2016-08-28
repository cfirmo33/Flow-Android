package com.yuyakaido.android.flow.presentation.item

import android.support.v4.app.Fragment
import com.yuyakaido.android.flow.domain.entity.Site
import com.yuyakaido.android.flow.presentation.fragment.CategoryPagerFragment

/**
 * Created by yuyakaido on 8/16/16.
 */
enum class HatenaItem() {
    Hot() {
        override fun fragment() = CategoryPagerFragment.newInstance(Site.HatenaHot)
    },
    New() {
        override fun fragment() = CategoryPagerFragment.newInstance(Site.HatenaNew)
    };

    abstract fun fragment(): Fragment

    companion object {
        private val DEFAULT = HatenaItem.Hot

        fun fromPosition(position: Int): HatenaItem {
            for (item in HatenaItem.values()) {
                if (item.ordinal == position) {
                    return item
                }
            }
            return DEFAULT
        }
    }
}