package com.yuyakaido.android.flow.domain.usecase

import android.content.Context
import com.yuyakaido.android.flow.app.Flow
import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.domain.entity.Site
import com.yuyakaido.android.flow.infra.repository.MenthasRepository
import com.yuyakaido.android.flow.infra.repository.QiitaRepository
import rx.Observable
import rx.Single
import javax.inject.Inject

/**
 * Created by yuyakaido on 7/30/16.
 */
class GetArticleUseCase(context: Context) {

    @Inject
    lateinit var menthasRepository: MenthasRepository

    @Inject
    lateinit var qiitaRepository: QiitaRepository

    init {
        Flow.getAppComponent(context)
                .newDomainComponent()
                .newGetArticleComponent()
                .inject(this)
    }

    fun getArticles(site: Site, category: Category): Single<List<Article>> {
        return when (site) {
            Site.Menthas -> menthasRepository.getArticles(category)
            Site.Qiita -> qiitaRepository.getArticles(category)
            else -> {
                Observable.empty<List<Article>>().toSingle()
            }
        }
    }

}