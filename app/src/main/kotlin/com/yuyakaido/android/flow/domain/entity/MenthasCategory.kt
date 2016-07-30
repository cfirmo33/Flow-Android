package com.yuyakaido.android.flow.domain.entity

/**
 * Created by yuyakaido on 6/20/16.
 */
data class MenthasCategory(val name: String) : Category {

    override fun name(): String {
        return name
    }

}