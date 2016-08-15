package com.yuyakaido.android.flow.infra.api.response

import com.google.gson.annotations.SerializedName

/**
 * Created by yuyakaido on 8/15/16.
 */
data class QiitaTagResponse(
        @SerializedName("id") val id: String,
        @SerializedName("icon_url") val iconUrl: String?)