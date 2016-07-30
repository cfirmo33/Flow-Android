package com.yuyakaido.android.flow.domain.entity

/**
 * Created by yuyakaido on 7/23/16.
 */
data class QiitaCategory(val name: String) : Category {

    override fun name(): String {
        return name
    }

}