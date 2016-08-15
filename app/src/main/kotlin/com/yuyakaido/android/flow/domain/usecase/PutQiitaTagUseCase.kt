package com.yuyakaido.android.flow.domain.usecase

import com.yuyakaido.android.flow.domain.entity.QiitaTag
import com.yuyakaido.android.flow.infra.repository.QiitaRepository
import rx.Single

/**
 * Created by yuyakaido on 8/15/16.
 */
class PutQiitaTagUseCase(private val repository: QiitaRepository) {

    fun putQiitaTag(tag: QiitaTag): Single<QiitaTag> {
        return repository.putTag(tag)
    }

}