package com.yuyakaido.android.flow.infra.api.common

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by yuyakaido on 6/25/16.
 */
class ApiClientGenerator {

    companion object {

        private val GSON = GsonBuilder().create()

        fun <T> generate(clazz: Class<T>, baseUrl: String): T {
            return Retrofit.Builder()
                    .client(HttpClient.httpClient)
                    .baseUrl(baseUrl)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(GSON))
                    .build()
                    .create(clazz)
        }

    }

}