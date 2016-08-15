package com.yuyakaido.android.flow.infra.api.client

import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.QiitaTag
import com.yuyakaido.android.flow.infra.api.converter.QiitaArticleConverter
import com.yuyakaido.android.flow.infra.api.converter.QiitaTagConverter
import rx.Single

/**
 * Created by yuyakaido on 7/23/16.
 */
open class QiitaClient(private val api: QiitaApi) {

    open fun getArticles(page: Int): Single<List<Article>> {
        return api.items(page).map { QiitaArticleConverter.convert(it) }
    }

    open fun getTagArticles(tag: QiitaTag, page: Int): Single<List<Article>> {
        return api.tagItems(tag.name, page).map { QiitaArticleConverter.convert(it) }
    }

    open fun getTags(): Single<List<QiitaTag>> {
        return api.tags(100, "count").map { QiitaTagConverter.convert(it) }
    }

}