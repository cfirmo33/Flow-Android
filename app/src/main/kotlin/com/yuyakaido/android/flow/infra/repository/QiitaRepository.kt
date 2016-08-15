package com.yuyakaido.android.flow.infra.repository

import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.QiitaTag
import com.yuyakaido.android.flow.infra.api.client.QiitaClient
import com.yuyakaido.android.flow.infra.dao.QiitaDao
import com.yuyakaido.android.flow.presentation.item.QiitaSubscription
import rx.Single

/**
 * Created by yuyakaido on 7/23/16.
 */
open class QiitaRepository(private val client: QiitaClient, private val dao: QiitaDao) {

    open fun getArticles(qiitaSubscription: QiitaSubscription, page: Int): Single<List<Article>> {
        return if (qiitaSubscription.isAll) {
            client.getArticles(page)
        } else {
            client.getTagArticles(qiitaSubscription.tag!!, page)
        }
    }

    open fun getTags(): Single<List<QiitaTag>> {
        return client.getTags()
                .doOnSuccess { dao.insertAll(it) }
                .flatMap { dao.findAll() }
    }

    open fun putTag(tag: QiitaTag): Single<QiitaTag> {
        return Single.create {
            dao.update(tag)
            it.onSuccess(tag)
        }
    }

    open fun getSubscribedTags(): Single<List<QiitaTag>> {
        return dao.findSubscribed()
    }

}