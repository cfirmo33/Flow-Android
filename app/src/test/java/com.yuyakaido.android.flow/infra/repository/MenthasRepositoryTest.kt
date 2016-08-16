package com.yuyakaido.android.flow.infra.repository

import com.sys1yagi.kmockito.invoked
import com.sys1yagi.kmockito.mock
import com.taroid.knit.should
import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.domain.entity.MenthasCategory
import com.yuyakaido.android.flow.infra.api.client.MenthasClient
import com.yuyakaido.android.flow.misc.FlowTest
import org.junit.Test
import rx.Single
import rx.observers.TestSubscriber

/**
 * Created by yuyakaido on 7/31/16.
 */
class MenthasRepositoryTest : FlowTest() {

    @Test
    fun getCategoriesTest() {
        val category = MenthasCategory("category", "category")
        val client = mock<MenthasClient>()
        client.getCategories().invoked.thenReturn(Single.just(arrayListOf()))
        client.getArticles(category, 0).invoked.thenReturn(Single.just(arrayListOf()))
        val repository = MenthasRepository(client)

        val categorySubscriber = TestSubscriber<List<Category>>()
        val articleSubscriber = TestSubscriber<List<Article>>()
        repository.getCategories().subscribe(categorySubscriber)
        repository.getArticles(category, 0).subscribe(articleSubscriber)

        categorySubscriber.assertNoErrors()
        categorySubscriber.onNextEvents.size.should be 1
        categorySubscriber.assertCompleted()

        articleSubscriber.assertNoErrors()
        articleSubscriber.onNextEvents.size.should be 1
        articleSubscriber.assertCompleted()
    }

}