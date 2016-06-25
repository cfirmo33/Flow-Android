package com.yuyakaido.android.flow.infra.api.client

import com.yuyakaido.android.flow.domain.MenthasCategory
import com.yuyakaido.android.flow.domain.MenthasArticle
import com.yuyakaido.android.flow.infra.api.common.ApiClientGenerator
import com.yuyakaido.android.flow.infra.api.converter.MenthasCategoryConverter
import com.yuyakaido.android.flow.infra.api.converter.MenthasPageConverter
import com.yuyakaido.android.flow.infra.constant.InfraConst
import rx.Observable

/**
 * Created by yuyakaido on 6/25/16.
 */
class MenthasClient {

    companion object {

        private val client = ApiClientGenerator.generate(
                MenthasApi::class.java,
                InfraConst.MENTHAS_BASE_URL)

        fun getCategories() : Observable<List<MenthasCategory>> {
            return client.getCategories().map { MenthasCategoryConverter.convert(it) }
        }

        fun getArticles(category: MenthasCategory) : Observable<List<MenthasArticle>> {
            return client.getArticles(category.name).map { MenthasPageConverter.convert(it) }
        }

    }

}