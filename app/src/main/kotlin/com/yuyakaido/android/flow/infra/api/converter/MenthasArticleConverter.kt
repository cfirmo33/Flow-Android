package com.yuyakaido.android.flow.infra.api.converter

import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.MenthasArticle
import com.yuyakaido.android.flow.infra.api.response.MenthasArticleListResponse

/**
 * Created by yuyakaido on 6/25/16.
 */
class MenthasArticleConverter {

    companion object {

        fun convert(response: MenthasArticleListResponse): List<Article> {
            return response.items
                    .map { MenthasArticle(it.page.title, it.page.url, it.page.thumbnail) }
                    .toList()
        }

    }

}