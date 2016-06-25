package com.yuyakaido.android.flow.infra.api.response

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by yuyakaido on 6/25/16.
 */
data class MenthasCategoryResponse(
        @SerializedName("category") val category: Category) {

    data class Category(
            @SerializedName("categories") val categories: ArrayList<String>)

}