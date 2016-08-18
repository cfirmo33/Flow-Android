package com.yuyakaido.android.flow.infra.api.client

import com.taroid.knit.should
import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.domain.entity.MenthasCategory
import com.yuyakaido.android.flow.infra.api.common.ApiClientGenerator
import com.yuyakaido.android.flow.misc.FlowTest
import com.yuyakaido.android.flow.util.ResponseUtil
import okhttp3.mockwebserver.MockWebServer
import org.junit.Test
import rx.observers.TestSubscriber
import java.io.File

/**
 * Created by yuyakaido on 7/30/16.
 */
class MenthasClientTest : FlowTest() {

    @Test
    fun getCategoriesTest() {
        val file = File("src/test/assets/response/menthas_category.json")
        val server = MockWebServer()
        server.enqueue(ResponseUtil.createMockResponse(file))
        server.start()

        val api = ApiClientGenerator.createJsonClient(MenthasApi::class.java, server.url("").toString())
        val client = MenthasClient(api)

        val subscriber = TestSubscriber<List<Category>>()
        client.getCategories().subscribe(subscriber)

        subscriber.assertNoErrors()
        subscriber.onNextEvents.size.should be 1
        subscriber.assertCompleted()
        subscriber.onNextEvents[0].size.should be 17

        server.shutdown()
    }

    @Test
    fun getArticlesTest() {
        val file = File("src/test/assets/response/menthas_article.json")
        val server = MockWebServer()
        server.enqueue(ResponseUtil.createMockResponse(file))
        server.start()

        val api = ApiClientGenerator.createJsonClient(MenthasApi::class.java, server.url("").toString())
        val client = MenthasClient(api)

        val subscriber = TestSubscriber<List<Article>>()
        client.getArticles(MenthasCategory("", ""), 0).subscribe(subscriber)

        subscriber.assertNoErrors()
        subscriber.onNextEvents.size.should be 1
        subscriber.assertCompleted()
        subscriber.onNextEvents[0].size.should be 33
    }

}