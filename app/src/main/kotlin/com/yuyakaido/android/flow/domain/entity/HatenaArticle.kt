package com.yuyakaido.android.flow.domain.entity

/**
 * Created by yuyakaido on 8/2/16.
 */
data class HatenaArticle(
        private val title: String,
        private val url: String,
        private val thumbnail: String?) : Article {

    override fun title(): String {
        return title
    }

    override fun url(): String {
        return url
    }

    override fun thumbnail(): String? {
        return thumbnail
    }

}