package com.yuyakaido.android.flow.infra.api.converter

import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.QiitaArticle
import com.yuyakaido.android.flow.infra.api.response.QiitaArticleResponse

/**
 * Created by yuyakaido on 7/23/16.
 */
class QiitaArticleConverter {

    companion object {

        fun convert(responses: List<QiitaArticleResponse>): List<Article> {
            return responses
                    .map { QiitaArticle(it.title, it.url) }
                    .toList()
        }

    }

}