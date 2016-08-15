package com.yuyakaido.android.flow.presentation.item

import android.support.v4.app.Fragment
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.domain.entity.Site
import com.yuyakaido.android.flow.presentation.fragment.CategoryPagerFragment

/**
 * Created by yuyakaido on 8/16/16.
 */
enum class HatenaItem(private val menuId: Int) {
    Hot(R.id.menu_hatena_hot) {
        override fun fragment() = CategoryPagerFragment.newInstance(Site.HatenaHot)
    },
    New(R.id.menu_hatena_new) {
        override fun fragment() = CategoryPagerFragment.newInstance(Site.HatenaNew)
    };

    abstract fun fragment(): Fragment

    companion object {
        private val DEFAULT = Hot

        fun fromMenuId(menuId: Int): HatenaItem {
            for (item in HatenaItem.values()) {
                if (item.menuId == menuId) {
                    return item
                }
            }
            return DEFAULT
        }
    }
}