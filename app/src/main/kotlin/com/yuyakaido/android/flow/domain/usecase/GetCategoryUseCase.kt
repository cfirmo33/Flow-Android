package com.yuyakaido.android.flow.domain.usecase

import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.domain.entity.Site
import com.yuyakaido.android.flow.infra.repository.HatenaRepository
import com.yuyakaido.android.flow.infra.repository.MenthasRepository
import rx.Observable
import javax.inject.Inject

/**
 * Created by yuyakaido on 7/30/16.
 */
class GetCategoryUseCase @Inject constructor(
        private val menthasRepository: MenthasRepository,
        private val hatenaRepository: HatenaRepository) {

    fun getCategories(site: Site): Observable<List<Category>> {
        return when (site) {
            Site.Menthas -> menthasRepository.getCategories().toObservable()
            Site.HatenaHot -> hatenaRepository.getCategories().toObservable()
            Site.HatenaNew -> hatenaRepository.getCategories().toObservable()
            else -> {
                Observable.empty<List<Category>>()
            }
        }
    }

}