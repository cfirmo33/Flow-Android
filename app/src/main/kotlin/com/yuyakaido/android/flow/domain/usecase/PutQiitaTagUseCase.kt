package com.yuyakaido.android.flow.domain.usecase

import com.yuyakaido.android.flow.domain.entity.QiitaTag
import com.yuyakaido.android.flow.infra.repository.QiitaRepository
import rx.Single
import javax.inject.Inject

/**
 * Created by yuyakaido on 8/15/16.
 */
class PutQiitaTagUseCase @Inject constructor(
        private val repository: QiitaRepository) {

    fun putQiitaTag(tag: QiitaTag): Single<QiitaTag> {
        return repository.putTag(tag)
    }

}