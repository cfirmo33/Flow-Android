package com.yuyakaido.android.flow.infra.repository

import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.infra.api.client.MenthasClient
import rx.Single
import javax.inject.Inject

/**
 * Created by yuyakaido on 6/25/16.
 */
open class MenthasRepository @Inject constructor(
        private val client: MenthasClient) {

    open fun getCategories(): Single<List<Category>> {
        return client.getCategories()
    }

    open fun getArticles(category: Category, offset: Int): Single<List<Article>> {
        return client.getArticles(category, offset)
    }

}