package com.yuyakaido.android.flow.domain.usecase

import com.sys1yagi.kmockito.invoked
import com.sys1yagi.kmockito.mock
import com.taroid.knit.should
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.domain.entity.HatenaCategory
import com.yuyakaido.android.flow.domain.entity.MenthasCategory
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
    fun getEmptyMenthasCategoriesTest() {
        val menthasRepository = mock<MenthasRepository>()
        val hatenaRepository = mock<HatenaRepository>()
        menthasRepository.getCategories().invoked.thenReturn(Single.just(arrayListOf()))

        val subscriber = TestSubscriber<List<Category>>()
        GetCategoryUseCase(menthasRepository, hatenaRepository)
                .getCategories(Site.Menthas)
                .subscribe(subscriber)

        subscriber.assertNoErrors()
        subscriber.onNextEvents.size.should be 1
        subscriber.assertCompleted()
    }

    @Test
    fun getMenthasCategoriesTest() {
        val size = 10
        val categories = Array(size) { it.toString() }
                .map { MenthasCategory(it, it) }
                .toList()

        val menthasRepository = mock<MenthasRepository>()
        val hatenaRepository = mock<HatenaRepository>()
        menthasRepository.getCategories().invoked.thenReturn(Single.just(categories))

        val subscriber = TestSubscriber<List<Category>>()
        GetCategoryUseCase(menthasRepository, hatenaRepository)
                .getCategories(Site.Menthas)
                .subscribe(subscriber)

        subscriber.assertNoErrors()
        subscriber.onNextEvents.size.should be 1
        subscriber.onNextEvents[0].size.should be size
        subscriber.onNextEvents[0].forEachIndexed { i, actual ->
            val expect = categories[i]

            actual.name().should be expect.name
            actual.api().should be expect.api
        }
        subscriber.assertCompleted()
    }

    @Test
    fun getEmptyHatenaHotCategoriesTest() {
        val menthasRepository = mock<MenthasRepository>()
        val hatenaRepository = mock<HatenaRepository>()
        hatenaRepository.getCategories().invoked.thenReturn(Single.just(listOf()))
        val useCase = GetCategoryUseCase(menthasRepository, hatenaRepository)

        val subscriber = TestSubscriber<List<Category>>()
        useCase.getCategories(Site.HatenaHot).subscribe(subscriber)

        subscriber.assertNoErrors()
        subscriber.onNextEvents.size.should be 1
        subscriber.assertCompleted()
    }

    @Test
    fun getHatenaHotCategoriesTest() {
        val size = 10
        val categories = Array(size) { it.toString() }
                .map { HatenaCategory(it, it) }
                .toList()

        val menthasRepository = mock<MenthasRepository>()
        val hatenaRepository = mock<HatenaRepository>()
        hatenaRepository.getCategories().invoked.thenReturn(Single.just(categories))

        val subscriber = TestSubscriber<List<Category>>()
        GetCategoryUseCase(menthasRepository, hatenaRepository)
                .getCategories(Site.HatenaHot)
                .subscribe(subscriber)

        subscriber.assertNoErrors()
        subscriber.onNextEvents.size.should be 1
        subscriber.onNextEvents[0].size.should be size
        subscriber.onNextEvents[0].forEachIndexed { i, actual ->
            val expect = categories[i]

            actual.name().should be expect.name
            actual.api().should be expect.api
        }
        subscriber.assertCompleted()
    }

    @Test
    fun getEmptyHatenaNewCategoriesTest() {
        val menthasRepository = mock<MenthasRepository>()
        val hatenaRepository = mock<HatenaRepository>()
        hatenaRepository.getCategories().invoked.thenReturn(Single.just(listOf()))
        val useCase = GetCategoryUseCase(menthasRepository, hatenaRepository)

        val subscriber = TestSubscriber<List<Category>>()
        useCase.getCategories(Site.HatenaNew).subscribe(subscriber)

        subscriber.assertNoErrors()
        subscriber.onNextEvents.size.should be 1
        subscriber.assertCompleted()
    }

    @Test
    fun getHatenaNewCategoriesTest() {
        val size = 10
        val categories = Array(size) { it.toString() }
                .map { HatenaCategory(it, it) }
                .toList()

        val menthasRepository = mock<MenthasRepository>()
        val hatenaRepository = mock<HatenaRepository>()
        hatenaRepository.getCategories().invoked.thenReturn(Single.just(categories))

        val subscriber = TestSubscriber<List<Category>>()
        GetCategoryUseCase(menthasRepository, hatenaRepository)
                .getCategories(Site.HatenaNew)
                .subscribe(subscriber)

        subscriber.assertNoErrors()
        subscriber.onNextEvents.size.should be 1
        subscriber.onNextEvents[0].size.should be size
        subscriber.onNextEvents[0].forEachIndexed { i, actual ->
            val expect = categories[i]

            actual.name().should be expect.name
            actual.api().should be expect.api
        }
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