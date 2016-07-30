package com.yuyakaido.android.flow.domain.usecase

import android.content.Context
import com.yuyakaido.android.flow.app.Flow
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.infra.repository.MenthasRepository
import rx.Single
import javax.inject.Inject

/**
 * Created by yuyakaido on 7/30/16.
 */
class GetCategoryUseCase(context: Context) {

    @Inject
    lateinit var repository: MenthasRepository

    init {
        Flow.getAppComponent(context)
                .newDomainComponent()
                .newGetCategoryComponent()
                .inject(this)
    }

    fun getCategories(): Single<List<Category>> {
        return repository.getCategories()
    }

}