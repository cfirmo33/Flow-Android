package com.yuyakaido.android.flow.infra.api.converter

import com.taroid.knit.should
import com.yuyakaido.android.flow.infra.api.response.HatenaArticleListResponse
import com.yuyakaido.android.flow.infra.api.response.HatenaArticleResponse
import com.yuyakaido.android.flow.misc.FlowTest
import org.junit.Test

/**
 * Created by yuyakaido on 8/5/16.
 */
class HatenaArticleConverterTest : FlowTest() {

    @Test
    fun emptyTest() {
        val response = HatenaArticleListResponse()
        response.items = listOf()

        val articles = HatenaArticleConverter.convert(response)

        articles.size.should be 0
    }

    @Test
    fun convertTest() {
        val size = 10
        val items = mutableListOf<HatenaArticleResponse>()
        for (i in 0..size) {
            val article = HatenaArticleResponse()
            article.title = i.toString()
            article.link = i.toString()
            items.add(article)
        }
        val response = HatenaArticleListResponse()
        response.items = items

        val articles = HatenaArticleConverter.convert(response)

        articles.size.should be response.items!!.size
        for (i in 0..size) {
            val article = articles[i]
            val item = response.items!![i]

            article.title().should be item.title
            article.url().should be item.link
            article.thumbnail().should be null
        }
    }

}