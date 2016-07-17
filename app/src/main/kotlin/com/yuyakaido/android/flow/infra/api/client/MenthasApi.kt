package com.yuyakaido.android.flow.infra.api.client

import com.yuyakaido.android.flow.infra.api.response.MenthasCategoryResponse
import com.yuyakaido.android.flow.infra.api.response.MenthasListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Single

/**
 * Created by yuyakaido on 6/25/16.
 */
interface MenthasApi {

    @GET("top/params")
    fun getCategories(): Single<MenthasCategoryResponse>

    @GET("{category}/list")
    fun getArticles(@Path("category") category: String): Single<MenthasListResponse>

}