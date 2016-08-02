package com.yuyakaido.android.flow.infra.api.converter

import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.HatenaArticle
import com.yuyakaido.android.flow.infra.api.response.HatenaArticleListResponse

/**
 * Created by yuyakaido on 8/2/16.
 */
class HatenaArticleConverter {

    companion object {

        fun convert(response: HatenaArticleListResponse): List<Article> {
            val articles = mutableListOf<Article>()
            response.items?.forEach {
                articles.add(HatenaArticle(it.title, it.link, null))
            }
            return articles
        }

    }

}