package com.yuyakaido.android.flow.presentation.item

import android.support.v4.app.Fragment
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.domain.entity.Site
import com.yuyakaido.android.flow.presentation.fragment.CategoryPagerFragment
import com.yuyakaido.android.flow.presentation.fragment.QiitaHomeFragment

/**
 * Created by yuyakaido on 7/23/16.
 */
enum class NavigationItem(val menuId: Int, val titleResId: Int) {
    Menthas(R.id.menu_main_menthas, R.string.common_menthas) {
        override fun fragment() = CategoryPagerFragment.newInstance(Site.Menthas)
    },
    Qiita(R.id.menu_main_qiita, R.string.common_qiita) {
        override fun fragment() = QiitaHomeFragment.newInstance()
    },
    Hatena(R.id.menu_main_hatena, R.string.common_hatena) {
        override fun fragment() = CategoryPagerFragment.newInstance(Site.Hatena)
    };

    abstract fun fragment(): Fragment

    companion object {
        private val DEFAULT = Menthas

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