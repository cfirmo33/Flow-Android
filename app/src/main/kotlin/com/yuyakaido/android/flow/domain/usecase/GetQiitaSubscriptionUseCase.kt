package com.yuyakaido.android.flow.domain.usecase

import com.yuyakaido.android.flow.infra.repository.QiitaRepository
import com.yuyakaido.android.flow.presentation.item.QiitaSubscription
import rx.Single
import javax.inject.Inject

/**
 * Created by yuyakaido on 8/15/16.
 */
class GetQiitaSubscriptionUseCase @Inject constructor(
        private val repository: QiitaRepository) {

    fun getQiitaSubscriptions(): Single<List<QiitaSubscription>> {
        return repository.getSubscribedTags()
                .map {
                    val subscriptions = mutableListOf<QiitaSubscription>()
                    subscriptions.add(QiitaSubscription(true, null))

                    it.forEach { subscriptions.add(QiitaSubscription(false, it)) }

                    subscriptions
                }
    }

}