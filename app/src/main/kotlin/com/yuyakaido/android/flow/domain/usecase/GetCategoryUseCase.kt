package com.yuyakaido.android.flow.domain.usecase

import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.infra.repository.MenthasRepository
import rx.Single

/**
 * Created by yuyakaido on 7/30/16.
 */
class GetCategoryUseCase(private val repository: MenthasRepository) {

    fun getCategories(): Single<List<Category>> {
        return repository.getCategories()
    }

}