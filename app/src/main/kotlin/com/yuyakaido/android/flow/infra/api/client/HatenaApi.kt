package com.yuyakaido.android.flow.infra.api.client

import com.yuyakaido.android.flow.infra.api.response.HatenaArticleListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Single

/**
 * Created by yuyakaido on 8/2/16.
 */
interface HatenaApi {

    @GET("hotentry/{category}")
    fun getHotEntries(@Path("category") category: String): Single<HatenaArticleListResponse>

    @GET("entrylist/{category}")
    fun getNewEntries(@Path("category") category: String): Single<HatenaArticleListResponse>

}