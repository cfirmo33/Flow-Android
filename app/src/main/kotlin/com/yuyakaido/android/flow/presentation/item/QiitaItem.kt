package com.yuyakaido.android.flow.presentation.item

import android.support.v4.app.Fragment
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.presentation.fragment.QiitaPostFragment
import com.yuyakaido.android.flow.presentation.fragment.QiitaTagFragment

/**
 * Created by yuyakaido on 8/15/16.
 */
enum class QiitaItem(private val menuId: Int) {
    Post(R.id.menu_qiita_post) {
        override fun fragment() = QiitaPostFragment.newInstance()
    },
    Tag(R.id.menu_qiita_tag) {
        override fun fragment() = QiitaTagFragment.newInstance()
    };

    abstract fun fragment(): Fragment

    companion object {
        private val DEFAULT = Tag

        fun fromMenuId(menuId: Int): QiitaItem {
            for (item in QiitaItem.values()) {
                if (item.menuId == menuId) {
                    return item
                }
            }
            return DEFAULT
        }
    }
}