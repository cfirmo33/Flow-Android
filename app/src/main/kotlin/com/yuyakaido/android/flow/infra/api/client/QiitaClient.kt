package com.yuyakaido.android.flow.infra.api.client

import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.infra.api.converter.QiitaArticleConverter
import rx.Single

/**
 * Created by yuyakaido on 7/23/16.
 */
open class QiitaClient(private val api: QiitaApi) {

    open fun getArticles(category: Category, page: Int): Single<List<Article>> {
        return api.articles(category.name(), page).map { QiitaArticleConverter.convert(it) }
    }

}