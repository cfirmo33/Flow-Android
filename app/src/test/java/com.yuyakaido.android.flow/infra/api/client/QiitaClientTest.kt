package com.yuyakaido.android.flow.infra.api.client

import com.taroid.knit.should
import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.infra.api.common.ApiClientGenerator
import com.yuyakaido.android.flow.misc.FlowTest
import com.yuyakaido.android.flow.util.ResponseUtil
import okhttp3.mockwebserver.MockWebServer
import org.junit.Test
import rx.observers.TestSubscriber
import java.io.File

/**
 * Created by yuyakaido on 7/31/16.
 */
class QiitaClientTest : FlowTest() {

    @Test
    fun getArticlesTest() {
        val file = File("src/test/assets/json/qiita_article.json")
        val server = MockWebServer()
        server.enqueue(ResponseUtil.createMockResponse(file))
        server.start()

        val api = ApiClientGenerator.createJsonClient(QiitaApi::class.java, server.url("").toString())
        val client = QiitaClient(api)

        val subscriber = TestSubscriber<List<Article>>()
        client.getArticles(0).subscribe(subscriber)

        subscriber.assertNoErrors()
        subscriber.onNextEvents.size.should be 1
        subscriber.assertCompleted()

        server.shutdown()
    }

}