package com.yuyakaido.android.flow.infra.api.client

import com.yuyakaido.android.flow.domain.Article
import com.yuyakaido.android.flow.domain.Category
import com.yuyakaido.android.flow.infra.api.common.ApiClientGenerator
import com.yuyakaido.android.flow.infra.api.converter.MenthasCategoryConverter
import com.yuyakaido.android.flow.infra.api.converter.MenthasArticleConverter
import com.yuyakaido.android.flow.infra.constant.InfraConst
import rx.Single

/**
 * Created by yuyakaido on 6/25/16.
 */
class MenthasClient {

    companion object {

        private val client = ApiClientGenerator.generate(
                MenthasApi::class.java,
                InfraConst.MENTHAS_BASE_URL)

        fun getCategories(): Single<List<Category>> {
            return client.categories().map { MenthasCategoryConverter.convert(it) }
        }

        fun getArticles(category: Category): Single<List<Article>> {
            return client.articles(category.name()).map { MenthasArticleConverter.convert(it) }
        }

    }

}