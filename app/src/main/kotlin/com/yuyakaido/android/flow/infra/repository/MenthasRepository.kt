package com.yuyakaido.android.flow.infra.repository

import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.infra.api.client.MenthasClient
import rx.Single

/**
 * Created by yuyakaido on 6/25/16.
 */
open class MenthasRepository(private val client: MenthasClient) : SiteRepository {

    open fun getCategories(): Single<List<Category>> {
        return client.getCategories()
    }

    override fun getArticles(category: Category, page: Int): Single<List<Article>> {
        return client.getArticles(category, page)
    }

}