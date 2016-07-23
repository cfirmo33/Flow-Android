package com.yuyakaido.android.flow.infra.api.client

import com.yuyakaido.android.flow.infra.api.response.QiitaArticleResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Single

/**
 * Created by yuyakaido on 7/23/16.
 */
interface QiitaApi {

    @GET("api/v2/items")
    fun articles(@Query("query") query: String): Single<List<QiitaArticleResponse>>

}