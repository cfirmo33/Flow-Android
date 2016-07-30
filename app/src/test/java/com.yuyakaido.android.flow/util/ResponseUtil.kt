package com.yuyakaido.android.flow.util

import okhttp3.mockwebserver.MockResponse
import okio.Okio
import java.io.File

/**
 * Created by yuyakaido on 7/30/16.
 */
class ResponseUtil {

    companion object {

        private val HTTP_STATUS_CODE_200 = 200

        fun createMockResponse(file: File): MockResponse {
            val source = Okio.buffer(Okio.source(file))
            val builder = StringBuilder()
            while (!source.exhausted()) {
                builder.append(source.readUtf8Line())
            }

            val mockResponse = MockResponse()
            mockResponse.setBody(builder.toString())
            mockResponse.setResponseCode(HTTP_STATUS_CODE_200)

            return mockResponse
        }

    }

}