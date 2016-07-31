package com.yuyakaido.android.flow.presentation.item

import android.support.v4.app.Fragment
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.presentation.fragment.MenthasCategoryFragment
import com.yuyakaido.android.flow.presentation.fragment.QiitaFragment

/**
 * Created by yuyakaido on 7/23/16.
 */
enum class NavigationItem(val menuId: Int) {
    Menthas(R.id.menu_main_menthas) {
        override fun fragment() = MenthasCategoryFragment.newInstance()
    },
    Qiita(R.id.menu_main_qiita) {
        override fun fragment() = QiitaFragment.newInstance()
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