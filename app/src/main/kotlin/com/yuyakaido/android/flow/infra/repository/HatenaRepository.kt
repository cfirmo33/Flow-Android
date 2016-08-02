package com.yuyakaido.android.flow.infra.repository

import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.infra.api.client.HatenaClient
import rx.Single

/**
 * Created by yuyakaido on 8/2/16.
 */
class HatenaRepository(private val client: HatenaClient) : SiteRepository {

    override fun getArticles(category: Category, page: Int): Single<List<Article>> {
        return client.getArticles(category)
    }

}