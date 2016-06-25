package com.yuyakaido.android.flow.infra.api.common

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by yuyakaido on 6/25/16.
 */
object HttpClient {

    val httpClient: OkHttpClient

    init {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BASIC
        httpClient = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
    }

}