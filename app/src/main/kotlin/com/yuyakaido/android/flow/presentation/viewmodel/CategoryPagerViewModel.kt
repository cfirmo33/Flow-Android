package com.yuyakaido.android.flow.presentation.viewmodel

import com.yuyakaido.android.flow.domain.entity.Site
import com.yuyakaido.android.flow.domain.usecase.GetCategoryUseCase
import javax.inject.Inject

/**
 * Created by yuyakaido on 9/24/16.
 */
class CategoryPagerViewModel @Inject constructor(
        getCategoryUseCase: GetCategoryUseCase,
        site: Site) : ViewModel {

    val categories = getCategoryUseCase.getCategories(site)

}