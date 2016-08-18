package com.yuyakaido.android.flow.infra.api.converter

import com.taroid.knit.should
import com.yuyakaido.android.flow.infra.api.response.QiitaTagResponse
import com.yuyakaido.android.flow.misc.FlowTest
import org.junit.Test

/**
 * Created by yuyakaido on 8/18/16.
 */
class QiitaTagConverterTest : FlowTest() {

    @Test
    fun emptyTest() {
        val responses = listOf<QiitaTagResponse>()

        val tags = QiitaTagConverter.convert(responses)

        tags.size.should be 0
    }

    @Test
    fun convertTest() {
        val size = 10
        val responses = Array(size) { i -> i.toString() }
                .map { s -> QiitaTagResponse(s) }
                .toList()
        val tags = QiitaTagConverter.convert(responses)

        tags.size.should be responses.size
        tags.forEachIndexed { i, tag ->
            val response = responses[i]

            tag.name.should be response.id
            tag.subscribed.should be false
        }
    }

}