package com.yuyakaido.android.flow.domain.usecase

import com.yuyakaido.android.flow.domain.entity.QiitaTag
import com.yuyakaido.android.flow.infra.repository.QiitaRepository
import rx.Single

/**
 * Created by yuyakaido on 8/15/16.
 */
class GetQiitaTagUseCase(private val repository: QiitaRepository) {

    fun getTags(): Single<List<QiitaTag>> {
        return repository.getTags()
    }

}