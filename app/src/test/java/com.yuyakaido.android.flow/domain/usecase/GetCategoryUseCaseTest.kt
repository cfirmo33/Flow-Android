package com.yuyakaido.android.flow.domain.usecase

import com.sys1yagi.kmockito.invoked
import com.sys1yagi.kmockito.mock
import com.taroid.knit.should
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.infra.repository.MenthasRepository
import org.junit.Test
import rx.Single
import rx.observers.TestSubscriber

/**
 * Created by yuyakaido on 7/31/16.
 */
class GetCategoryUseCaseTest {

    @Test
    fun getCategoriesTest() {
        val repository = mock<MenthasRepository>()
        repository.getCategories().invoked.thenReturn(Single.just(arrayListOf()))
        val useCase = GetCategoryUseCase(repository)

        val subscriber = TestSubscriber<List<Category>>()
        useCase.getCategories().subscribe(subscriber)

        subscriber.assertNoErrors()
        subscriber.onNextEvents.size.should be 1
        subscriber.assertCompleted()
    }

}