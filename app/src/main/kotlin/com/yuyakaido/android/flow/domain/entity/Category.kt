package com.yuyakaido.android.flow.domain.entity

import java.io.Serializable

/**
 * Created by yuyakaido on 7/23/16.
 */
interface Category : Serializable {
    fun name(): String
    fun api(): String
}