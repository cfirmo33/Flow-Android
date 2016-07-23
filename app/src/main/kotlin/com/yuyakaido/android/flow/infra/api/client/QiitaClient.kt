package com.yuyakaido.android.flow.infra.api.client

import com.yuyakaido.android.flow.domain.Article
import com.yuyakaido.android.flow.domain.Category
import com.yuyakaido.android.flow.infra.api.common.ApiClientGenerator
import com.yuyakaido.android.flow.infra.api.converter.QiitaArticleConverter
import com.yuyakaido.android.flow.infra.constant.InfraConst
import rx.Single

/**
 * Created by yuyakaido on 7/23/16.
 */
class QiitaClient {

    companion object {

        private val client = ApiClientGenerator.generate(
                QiitaApi::class.java,
                InfraConst.QIITA_BASE_URL)

        fun getArticles(category: Category): Single<List<Article>> {
            return client.articles(category.name()).map { QiitaArticleConverter.convert(it) }
        }

    }

}