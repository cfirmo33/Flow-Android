package com.yuyakaido.android.flow.infra.api.client

import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.infra.api.converter.QiitaArticleConverter
import rx.Single

/**
 * Created by yuyakaido on 7/23/16.
 */
class QiitaClient(private val api: QiitaApi) {

    fun getArticles(category: Category): Single<List<Article>> {
        return api.articles(category.name()).map { QiitaArticleConverter.convert(it) }
    }

}