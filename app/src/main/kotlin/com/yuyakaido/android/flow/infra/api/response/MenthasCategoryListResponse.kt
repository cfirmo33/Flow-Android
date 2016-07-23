package com.yuyakaido.android.flow.infra.api.response

import com.google.gson.annotations.SerializedName

/**
 * Created by yuyakaido on 6/25/16.
 */
data class MenthasCategoryListResponse(
        @SerializedName("category") val category: Category) {

    data class Category(
            @SerializedName("categories") val categories: List<String>)

}