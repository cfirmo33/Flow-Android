package com.yuyakaido.android.flow.infra.dao

import com.yuyakaido.android.flow.domain.entity.OrmaDatabase
import com.yuyakaido.android.flow.domain.entity.QiitaTag
import rx.Single

/**
 * Created by yuyakaido on 8/15/16.
 */
class QiitaDao(private val orma: OrmaDatabase) {

    fun insertAll(tags: List<QiitaTag>) {
        orma.prepareInsertIntoQiitaTag().executeAll(tags)
    }

    fun update(tag: QiitaTag) {
        orma.updateQiitaTag()
                .where("name = ?", tag.name)
                .subscribed(tag.subscribed)
                .execute()
    }

    fun findAll(): Single<List<QiitaTag>> {
        return orma.selectFromQiitaTag()
                .executeAsObservable()
                .toList()
                .toSingle()
    }

    fun findSubscribed(): Single<List<QiitaTag>> {
        return orma.selectFromQiitaTag()
                .where("subscribed = ?", true)
                .executeAsObservable()
                .toList()
                .toSingle()
    }

}