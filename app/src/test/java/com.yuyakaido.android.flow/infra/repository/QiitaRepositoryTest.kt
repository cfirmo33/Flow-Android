package com.yuyakaido.android.flow.infra.repository

import com.sys1yagi.kmockito.invoked
import com.sys1yagi.kmockito.mock
import com.taroid.knit.should
import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.QiitaCategory
import com.yuyakaido.android.flow.infra.api.client.QiitaClient
import com.yuyakaido.android.flow.misc.FlowTest
import org.junit.Test
import rx.Single
import rx.observers.TestSubscriber

/**
 * Created by yuyakaido on 7/31/16.
 */
class QiitaRepositoryTest : FlowTest() {

    @Test
    fun getArticlesTest() {
        val category = QiitaCategory("android")
        val client = mock<QiitaClient>()
        client.getArticles(category, 0).invoked.thenReturn(Single.just(arrayListOf()))
        val repository = QiitaRepository(client)

        val subscriber = TestSubscriber<List<Article>>()
        repository.getArticles(category, 0).subscribe(subscriber)

        subscriber.assertNoErrors()
        subscriber.onNextEvents.size.should be 1
        subscriber.assertCompleted()
    }

}