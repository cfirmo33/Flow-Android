package com.yuyakaido.android.flow.infra.repository

import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.domain.entity.HatenaCategory
import com.yuyakaido.android.flow.infra.api.client.HatenaClient
import rx.Single

/**
 * Created by yuyakaido on 8/2/16.
 */
class HatenaRepository(private val client: HatenaClient) {

    fun getCategories(): Single<List<Category>> {
        val categories = mutableListOf<Category>()
        categories.add(HatenaCategory("social.rss"))
        categories.add(HatenaCategory("economics.rss"))
        categories.add(HatenaCategory("life.rss"))
        categories.add(HatenaCategory("knowledge.rss"))
        categories.add(HatenaCategory("it.rss"))
        categories.add(HatenaCategory("fun.rss"))
        categories.add(HatenaCategory("entertainment.rss"))
        categories.add(HatenaCategory("game.rss"))
        return Single.just(categories)
    }

    fun getHotArticles(category: Category): Single<List<Article>> {
        return client.getHotArticles(category)
    }

    fun getNewArticles(category: Category): Single<List<Article>> {
        return client.getNewArticles(category)
    }

}