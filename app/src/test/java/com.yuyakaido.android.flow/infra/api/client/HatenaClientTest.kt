package com.yuyakaido.android.flow.infra.api.client

import com.taroid.knit.should
import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.HatenaCategory
import com.yuyakaido.android.flow.infra.api.common.ApiClientGenerator
import com.yuyakaido.android.flow.misc.FlowTest
import com.yuyakaido.android.flow.util.ResponseUtil
import okhttp3.mockwebserver.MockWebServer
import org.junit.Test
import rx.observers.TestSubscriber
import java.io.File

/**
 * Created by yuyakaido on 8/18/16.
 */
class HatenaClientTest : FlowTest() {

    @Test
    fun getHotArticlesTest() {
        val file = File("src/test/assets/response/hatena_hot_article.xml")
        val server = MockWebServer()
        server.enqueue(ResponseUtil.createMockResponse(file))
        server.start()

        val api = ApiClientGenerator.createXmlClient(HatenaApi::class.java, server.url("").toString())
        val client = HatenaClient(api)

        val subscriber = TestSubscriber<List<Article>>()
        client.getHotArticles(HatenaCategory("", "")).subscribe(subscriber)

        subscriber.assertNoErrors()
        subscriber.onNextEvents.size.should be 1
        subscriber.assertCompleted()
        subscriber.onNextEvents[0].size.should be 30

        server.shutdown()
    }

    @Test
    fun getNewArticlesTest() {
        val file = File("src/test/assets/response/hatena_new_article.xml")
        val server = MockWebServer()
        server.enqueue(ResponseUtil.createMockResponse(file))
        server.start()

        val api = ApiClientGenerator.createXmlClient(HatenaApi::class.java, server.url("").toString())
        val client = HatenaClient(api)

        val subscriber = TestSubscriber<List<Article>>()
        client.getHotArticles(HatenaCategory("", "")).subscribe(subscriber)

        subscriber.assertNoErrors()
        subscriber.onNextEvents.size.should be 1
        subscriber.assertCompleted()
        subscriber.onNextEvents[0].size.should be 30

        server.shutdown()
    }

}