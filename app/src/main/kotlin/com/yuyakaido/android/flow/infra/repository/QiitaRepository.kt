package com.yuyakaido.android.flow.infra.repository

import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.infra.api.client.QiitaClient
import rx.Single

/**
 * Created by yuyakaido on 7/23/16.
 */
open class QiitaRepository(private val client: QiitaClient) {

    open fun getArticles(category: Category, page: Int): Single<List<Article>> {
        return client.getArticles(category, page)
    }

}