package com.yuyakaido.android.flow.infra.api.converter

import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.domain.entity.MenthasCategory
import com.yuyakaido.android.flow.infra.api.response.MenthasCategoryListResponse

/**
 * Created by yuyakaido on 6/25/16.
 */
class MenthasCategoryConverter {

    companion object {

        fun convert(response: MenthasCategoryListResponse): List<Category> {
            return response.category.categories
                    .map { MenthasCategory(it, it) }
                    .toList()
        }

    }

}