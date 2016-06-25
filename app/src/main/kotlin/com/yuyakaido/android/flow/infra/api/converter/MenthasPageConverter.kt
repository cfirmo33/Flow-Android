package com.yuyakaido.android.flow.infra.api.converter

import com.yuyakaido.android.flow.domain.MenthasArticle
import com.yuyakaido.android.flow.infra.api.response.MenthasListResponse

/**
 * Created by yuyakaido on 6/25/16.
 */
class MenthasPageConverter {

    companion object {

        fun convert(response: MenthasListResponse) : List<MenthasArticle> {
            val articles = mutableListOf<MenthasArticle>()
            response.items.forEach {
                articles.add(MenthasArticle(it.page.title, it.page.url, it.page.thumbnail))
            }
            return articles
        }

    }

}