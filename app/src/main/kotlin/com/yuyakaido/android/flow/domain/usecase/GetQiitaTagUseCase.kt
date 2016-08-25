package com.yuyakaido.android.flow.domain.usecase

import com.yuyakaido.android.flow.domain.entity.QiitaTag
import com.yuyakaido.android.flow.infra.repository.QiitaRepository
import rx.Single
import javax.inject.Inject

/**
 * Created by yuyakaido on 8/15/16.
 */
class GetQiitaTagUseCase @Inject constructor(
        private val repository: QiitaRepository) {

    fun getQiitaTags(): Single<List<QiitaTag>> {
        return repository.getTags()
    }

}