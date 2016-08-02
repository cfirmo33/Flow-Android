package com.yuyakaido.android.flow.infra.api.client

import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.infra.api.converter.HatenaArticleConverter
import rx.Single

/**
 * Created by yuyakaido on 8/2/16.
 */
class HatenaClient(private val api: HatenaApi) {

    fun getArticles(category: Category): Single<List<Article>> {
        return api.getEntries(category.name())
                .map { HatenaArticleConverter.convert(it) }
    }

}