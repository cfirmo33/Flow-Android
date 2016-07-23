package com.yuyakaido.android.flow.infra.repository

import com.yuyakaido.android.flow.domain.Article
import com.yuyakaido.android.flow.domain.Category
import com.yuyakaido.android.flow.infra.api.client.MenthasClient
import rx.Single

/**
 * Created by yuyakaido on 6/25/16.
 */
class MenthasRepository {

    companion object {

        fun getCategories(): Single<List<Category>> {
            return MenthasClient.getCategories()
        }

        fun getArticles(category: Category): Single<List<Article>> {
            return MenthasClient.getArticles(category)
        }

    }

}