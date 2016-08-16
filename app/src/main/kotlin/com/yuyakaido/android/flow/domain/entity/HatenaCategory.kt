package com.yuyakaido.android.flow.domain.entity

/**
 * Created by yuyakaido on 8/2/16.
 */
class HatenaCategory(val name: String, val api: String) : Category {

    override fun name(): String {
        return name
    }

    override fun api(): String {
        return api
    }
}