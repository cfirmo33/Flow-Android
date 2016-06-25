package com.yuyakaido.android.flow.infra.api.converter

import com.yuyakaido.android.flow.domain.MenthasCategory
import com.yuyakaido.android.flow.infra.api.response.MenthasCategoryResponse

/**
 * Created by yuyakaido on 6/25/16.
 */
class MenthasCategoryConverter {

    companion object {

        fun convert(response: MenthasCategoryResponse) : List<MenthasCategory> {
            val categories = mutableListOf<MenthasCategory>()
            response.category.categories.forEach {
                categories.add(MenthasCategory(it))
            }
            return categories
        }

    }

}