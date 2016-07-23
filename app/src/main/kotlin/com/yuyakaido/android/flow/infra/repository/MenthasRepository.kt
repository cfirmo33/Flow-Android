package com.yuyakaido.android.flow.infra.repository

import com.yuyakaido.android.flow.domain.MenthasArticle
import com.yuyakaido.android.flow.domain.MenthasCategory
import com.yuyakaido.android.flow.infra.api.client.MenthasClient
import rx.Single

/**
 * Created by yuyakaido on 6/25/16.
 */
class MenthasRepository {

    companion object {

        fun getCategories() : Single<List<MenthasCategory>> {
            return MenthasClient.getCategories()
        }

        fun getArticles(category: MenthasCategory) : Single<List<MenthasArticle>> {
            return MenthasClient.getArticles(category)
        }

    }

}