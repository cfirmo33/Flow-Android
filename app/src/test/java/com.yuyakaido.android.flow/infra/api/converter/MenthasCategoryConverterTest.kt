package com.yuyakaido.android.flow.infra.api.converter

import com.taroid.knit.should
import com.yuyakaido.android.flow.infra.api.response.MenthasCategoryListResponse
import com.yuyakaido.android.flow.misc.FlowTest
import org.junit.Test

/**
 * Created by yuyakaido on 7/31/16.
 */
class MenthasCategoryConverterTest : FlowTest() {

    @Test
    fun emptyTest() {
        val category = MenthasCategoryListResponse.Category(listOf())
        val response = MenthasCategoryListResponse(category)

        val categories = MenthasCategoryConverter.convert(response)

        categories.size.should be 0
    }

    @Test
    fun convertTest() {
        val size = 10
        val categoryStrings = mutableListOf<String>()
        for (i in 0..size) {
            categoryStrings.add(i.toString())
        }
        val category = MenthasCategoryListResponse.Category(categoryStrings);
        val response = MenthasCategoryListResponse(category)

        val categories = MenthasCategoryConverter.convert(response)

        categories.size.should be categoryStrings.size
        for (i in 0..size) {
            categories[i].name().should be categoryStrings[i]
        }
    }

}