package com.yuyakaido.android.flow.infra.dao

import com.yuyakaido.android.flow.domain.entity.OrmaDatabase
import com.yuyakaido.android.flow.domain.entity.QiitaTag
import rx.Single
import javax.inject.Inject

/**
 * Created by yuyakaido on 8/15/16.
 */
class QiitaDao @Inject constructor(bridge: OrmaBridge) {

    private val orma: OrmaDatabase

    init {
        orma = bridge.orma
    }

    fun insertAll(tags: List<QiitaTag>) {
        orma.prepareInsertIntoQiitaTag().executeAll(tags)
    }

    fun update(tag: QiitaTag): Single<Int> {
        return orma.updateQiitaTag()
                .where("name = ?", tag.name)
                .subscribed(tag.subscribed)
                .executeAsObservable()
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