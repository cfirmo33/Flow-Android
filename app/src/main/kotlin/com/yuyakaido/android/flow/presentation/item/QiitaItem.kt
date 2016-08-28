package com.yuyakaido.android.flow.presentation.item

import android.support.v4.app.Fragment
import com.yuyakaido.android.flow.presentation.fragment.QiitaPostFragment
import com.yuyakaido.android.flow.presentation.fragment.QiitaTagFragment

/**
 * Created by yuyakaido on 8/15/16.
 */
enum class QiitaItem() {
    Post() {
        override fun fragment() = QiitaPostFragment.newInstance()
    },
    Tag() {
        override fun fragment() = QiitaTagFragment.newInstance()
    };

    abstract fun fragment(): Fragment

    companion object {
        private val DEFAULT = QiitaItem.Post

        fun fromPosition(position: Int): QiitaItem {
            for (item in QiitaItem.values()) {
                if (item.ordinal == position) {
                    return item
                }
            }
            return DEFAULT
        }
    }
}