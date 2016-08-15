package com.yuyakaido.android.flow.infra.api.client

import com.yuyakaido.android.flow.infra.api.response.QiitaArticleResponse
import com.yuyakaido.android.flow.infra.api.response.QiitaTagResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Single

/**
 * Created by yuyakaido on 7/23/16.
 */
interface QiitaApi {

    @GET("api/v2/items")
    fun items(@Query("page") page: Int): Single<List<QiitaArticleResponse>>

    @GET("api/v2/tags/{tag}/items")
    fun tagItems(@Path("tag") tag: String, @Query("page") page: Int): Single<List<QiitaArticleResponse>>

    @GET("api/v2/tags")
    fun tags(@Query("per_page") perPage: Int, @Query("sort") sort: String): Single<List<QiitaTagResponse>>

}