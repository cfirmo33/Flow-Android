package com.yuyakaido.android.flow.domain.usecase

import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.domain.entity.Site
import com.yuyakaido.android.flow.infra.repository.HatenaRepository
import com.yuyakaido.android.flow.infra.repository.MenthasRepository
import rx.Single
import javax.inject.Inject

/**
 * Created by yuyakaido on 7/30/16.
 */
class GetCategoryUseCase @Inject constructor(
        private val menthasRepository: MenthasRepository,
        private val hatenaRepository: HatenaRepository) {

    fun getCategories(site: Site): Single<List<Category>> {
        return when (site) {
            Site.Menthas -> menthasRepository.getCategories()
            Site.HatenaHot -> hatenaRepository.getCategories()
            Site.HatenaNew -> hatenaRepository.getCategories()
            else -> {
                Single.error<List<Category>>(IllegalArgumentException())
            }
        }
    }

}