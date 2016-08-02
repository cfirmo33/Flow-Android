package com.yuyakaido.android.flow.presentation.item

import android.support.v4.app.Fragment
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.domain.entity.Site
import com.yuyakaido.android.flow.presentation.fragment.CategoryPagerFragment

/**
 * Created by yuyakaido on 7/23/16.
 */
enum class NavigationItem(val menuId: Int) {
    Menthas(R.id.menu_main_menthas) {
        override fun fragment() = CategoryPagerFragment.newInstance(Site.Menthas)
    },
    Qiita(R.id.menu_main_qiita) {
        override fun fragment() = CategoryPagerFragment.newInstance(Site.Qiita)
    },
    Hatena(R.id.menu_main_hatena) {
        override fun fragment() = CategoryPagerFragment.newInstance(Site.Hatena)
    };

    abstract fun fragment(): Fragment

    companion object {
        val DEFAULT = Menthas

        fun fromMenuId(menuId: Int): NavigationItem {
            for (item in values()) {
                if (item.menuId == menuId) {
                    return item
                }
            }
            return DEFAULT
        }
    }
}