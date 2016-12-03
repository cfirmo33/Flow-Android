package com.yuyakaido.android.flow.domain.entity

/**
 * Created by yuyakaido on 7/23/16.
 */
data class QiitaArticle(
        private val title: String,
        private val url: String) : Article {

    override fun title(): String {
        return title
    }

    override fun url(): String {
        return url
    }

    override fun thumbnail(): String? {
        return null
    }

}