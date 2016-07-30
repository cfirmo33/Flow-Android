package com.yuyakaido.android.flow.infra.api.converter

import com.taroid.knit.should
import com.yuyakaido.android.flow.infra.api.response.QiitaArticleResponse
import com.yuyakaido.android.flow.misc.FlowTest
import org.junit.Test

/**
 * Created by yuyakaido on 7/31/16.
 */
class QiitaArticleConverterTest : FlowTest() {

    @Test
    fun emptyTest() {
        val responses = listOf<QiitaArticleResponse>()

        val articles = QiitaArticleConverter.convert(responses)

        articles.size.should be 0
    }

    @Test
    fun convertTest() {
        val responses = mutableListOf<QiitaArticleResponse>()
        val size = 10
        for (i in 0..size) {
            responses.add(QiitaArticleResponse(i.toString(), i.toString()))
        }

        val articles = QiitaArticleConverter.convert(responses)

        articles.size.should be responses.size
        for (i in 0..size) {
            val response = responses[i]
            val article = articles[i]
            article.title().should be response.title
            article.url().should be response.url
            article.thumbnail().should be null
        }
    }

}