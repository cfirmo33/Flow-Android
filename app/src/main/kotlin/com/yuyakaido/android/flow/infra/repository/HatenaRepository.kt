package com.yuyakaido.android.flow.infra.repository

import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.domain.entity.HatenaCategory
import com.yuyakaido.android.flow.infra.api.client.HatenaClient
import rx.Single
import javax.inject.Inject

/**
 * Created by yuyakaido on 8/2/16.
 */
open class HatenaRepository @Inject constructor(
        private val client: HatenaClient) {

    open fun getCategories(): Single<List<Category>> {
        val categories = mutableListOf<Category>()
        categories.add(HatenaCategory("Social", "social.rss"))
        categories.add(HatenaCategory("Economics", "economics.rss"))
        categories.add(HatenaCategory("Life", "life.rss"))
        categories.add(HatenaCategory("Knowledge", "knowledge.rss"))
        categories.add(HatenaCategory("IT", "it.rss"))
        categories.add(HatenaCategory("Fun", "fun.rss"))
        categories.add(HatenaCategory("Entertainment", "entertainment.rss"))
        categories.add(HatenaCategory("Game", "game.rss"))
        return Single.just(categories)
    }

    open fun getHotArticles(category: Category): Single<List<Article>> {
        return client.getHotArticles(category)
    }

    open fun getNewArticles(category: Category): Single<List<Article>> {
        return client.getNewArticles(category)
    }

}