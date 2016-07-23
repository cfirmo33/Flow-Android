package com.yuyakaido.android.flow.infra.api.client

import com.yuyakaido.android.flow.infra.api.response.MenthasCategoryListResponse
import com.yuyakaido.android.flow.infra.api.response.MenthasArticleListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Single

/**
 * Created by yuyakaido on 6/25/16.
 */
interface MenthasApi {

    @GET("top/params")
    fun categories(): Single<MenthasCategoryListResponse>

    @GET("{category}/list")
    fun articles(@Path("category") category: String): Single<MenthasArticleListResponse>

}