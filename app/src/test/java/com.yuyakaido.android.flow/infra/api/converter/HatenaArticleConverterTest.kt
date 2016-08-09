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
        val response = HatenaArticleListResponse()
        response.items = Array(size) { i -> i.toString() }
                .map { s ->
                    HatenaArticleResponse().apply {
                        title = s
                        link = s
                    }
                }
                .toList()

        val articles = HatenaArticleConverter.convert(response)

        articles.size.should be response.items!!.size
        articles.forEachIndexed { i, article ->
            val item = response.items!![i]

            article.title().should be item.title
            article.url().should be item.link
            article.thumbnail().should be null
        }
    }

}