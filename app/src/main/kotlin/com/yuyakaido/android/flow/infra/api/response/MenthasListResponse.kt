package com.yuyakaido.android.flow.infra.api.response

import com.google.gson.annotations.SerializedName

/**
 * Created by yuyakaido on 6/25/16.
 */
data class MenthasListResponse(@SerializedName("items") val items: List<Item>) {

    data class Item(@SerializedName("page") val page: Page)

    data class Page(
            @SerializedName("title") val title: String,
            @SerializedName("url") val url: String,
            @SerializedName("thumbnail") val thumbnail: String)

}