package com.yuyakaido.android.flow.infra.api.common

import com.facebook.stetho.okhttp3.StethoInterceptor
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
                .addNetworkInterceptor(logger)
                .addNetworkInterceptor(StethoInterceptor())
                .build()
    }

}