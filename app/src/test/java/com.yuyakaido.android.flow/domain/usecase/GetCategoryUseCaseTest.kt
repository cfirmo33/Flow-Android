package com.yuyakaido.android.flow.domain.usecase

import com.sys1yagi.kmockito.invoked
import com.sys1yagi.kmockito.mock
import com.taroid.knit.should
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.domain.entity.Site
import com.yuyakaido.android.flow.infra.repository.HatenaRepository
import com.yuyakaido.android.flow.infra.repository.MenthasRepository
import com.yuyakaido.android.flow.misc.FlowTest
import org.junit.Test
import rx.Single
import rx.observers.TestSubscriber

/**
 * Created by yuyakaido on 7/31/16.
 */
class GetCategoryUseCaseTest : FlowTest() {

    @Test
    fun getMenthasCategoriesTest() {
        val menthasRepository = mock<MenthasRepository>()
        val hatenaRepository = mock<HatenaRepository>()
        menthasRepository.getCategories().invoked.thenReturn(Single.just(arrayListOf()))
        val useCase = GetCategoryUseCase(menthasRepository, hatenaRepository)

        val subscriber = TestSubscriber<List<Category>>()
        useCase.getCategories(Site.Menthas).subscribe(subscriber)

        subscriber.assertNoErrors()
        subscriber.onNextEvents.size.should be 1
        subscriber.assertCompleted()
    }

    @Test
    fun getHatenaHotCategoriesTest() {
        val menthasRepository = mock<MenthasRepository>()
        val hatenaRepository = mock<HatenaRepository>()
        hatenaRepository.getCategories().invoked.thenReturn(Single.just(arrayListOf()))
        val useCase = GetCategoryUseCase(menthasRepository, hatenaRepository)

        val subscriber = TestSubscriber<List<Category>>()
        useCase.getCategories(Site.HatenaHot).subscribe(subscriber)

        subscriber.assertNoErrors()
        subscriber.onNextEvents.size.should be 1
        subscriber.assertCompleted()
    }

    @Test
    fun getHatenaNewCategoriesTest() {
        val menthasRepository = mock<MenthasRepository>()
        val hatenaRepository = mock<HatenaRepository>()
        hatenaRepository.getCategories().invoked.thenReturn(Single.just(arrayListOf()))
        val useCase = GetCategoryUseCase(menthasRepository, hatenaRepository)

        val subscriber = TestSubscriber<List<Category>>()
        useCase.getCategories(Site.HatenaNew).subscribe(subscriber)

        subscriber.assertNoErrors()
        subscriber.onNextEvents.size.should be 1
        subscriber.assertCompleted()
    }

    @Test
    fun getQiitaCategoriesTest() {
        val menthasRepository = mock<MenthasRepository>()
        val hatenaRepository = mock<HatenaRepository>()
        val useCase = GetCategoryUseCase(menthasRepository, hatenaRepository)

        val subscriber = TestSubscriber<List<Category>>()
        useCase.getCategories(Site.Qiita).subscribe(subscriber)

        subscriber.assertNoErrors()
        subscriber.onNextEvents.size.should be 0
        subscriber.assertCompleted()
    }

}