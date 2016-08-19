package com.yuyakaido.android.flow.infra.api.client

import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.infra.api.converter.MenthasArticleConverter
import com.yuyakaido.android.flow.infra.api.converter.MenthasCategoryConverter
import rx.Single

/**
 * Created by yuyakaido on 6/25/16.
 */
open class MenthasClient(private val api: MenthasApi) {

    open fun getCategories(): Single<List<Category>> {
        return api.categories().map { MenthasCategoryConverter.convert(it) }
    }

    open fun getArticles(category: Category, offset: Int): Single<List<Article>> {
        return api.articles(category.name(), offset).map { MenthasArticleConverter.convert(it) }
    }

}