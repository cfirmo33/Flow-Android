package com.yuyakaido.android.flow.infra.repository

import com.yuyakaido.android.flow.domain.Article
import com.yuyakaido.android.flow.domain.Category
import com.yuyakaido.android.flow.infra.api.client.QiitaClient
import rx.Single

/**
 * Created by yuyakaido on 7/23/16.
 */
class QiitaRepository {

    companion object {

        fun getArticles(category: Category): Single<List<Article>> {
            return QiitaClient.getArticles(category)
        }

    }

}