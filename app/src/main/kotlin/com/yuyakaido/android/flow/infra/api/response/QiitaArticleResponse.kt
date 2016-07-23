package com.yuyakaido.android.flow.infra.api.response

import com.google.gson.annotations.SerializedName

/**
 * Created by yuyakaido on 7/23/16.
 */
data class QiitaArticleResponse(
        @SerializedName("title") val title: String,
        @SerializedName("url") val url: String)