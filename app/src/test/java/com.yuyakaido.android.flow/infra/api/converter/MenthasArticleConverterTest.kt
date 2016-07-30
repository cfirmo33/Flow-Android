package com.yuyakaido.android.flow.infra.api.converter

import com.taroid.knit.should
import com.yuyakaido.android.flow.infra.api.response.MenthasArticleListResponse
import com.yuyakaido.android.flow.misc.FlowTest
import org.junit.Test

/**
 * Created by yuyakaido on 7/31/16.
 */
class MenthasArticleConverterTest : FlowTest() {

    @Test
    fun emptyTest() {
        val response = MenthasArticleListResponse(listOf())

        val articles = MenthasArticleConverter.convert(response)

        articles.size.should be 0
    }

    @Test
    fun convertTest() {
        val size = 10
        val items = mutableListOf<MenthasArticleListResponse.Item>()
        for (i in 0..size) {
            val page = MenthasArticleListResponse.Page(i.toString(), i.toString(), i.toString())
            items.add(MenthasArticleListResponse.Item(page))
        }
        val response = MenthasArticleListResponse(items)

        val articles = MenthasArticleConverter.convert(response)

        articles.size.should be response.items.size
        for (i in 0..size) {
            val article = articles[i]
            val page = response.items[i].page

            article.title().should be page.title
            article.url().should be page.url
            article.thumbnail().should be page.thumbnail
        }
    }

}