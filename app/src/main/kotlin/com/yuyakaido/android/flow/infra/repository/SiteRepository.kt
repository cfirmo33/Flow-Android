package com.yuyakaido.android.flow.infra.repository

import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.Category
import rx.Single

/**
 * Created by yuyakaido on 7/30/16.
 */
interface SiteRepository {

    fun getArticles(category: Category, page: Int): Single<List<Article>>

}