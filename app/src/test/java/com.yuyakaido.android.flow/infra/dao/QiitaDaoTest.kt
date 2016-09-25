package com.yuyakaido.android.flow.infra.dao

import com.taroid.knit.should
import com.yuyakaido.android.flow.domain.entity.QiitaTag
import org.junit.Before
import org.junit.Test
import rx.observers.TestSubscriber

/**
 * Created by yuyakaido on 8/18/16.
 */
class QiitaDaoTest : DaoTest() {

    private lateinit var dao: QiitaDao

    @Before
    override fun setUp() {
        super.setUp()
        dao = QiitaDao(orma)
    }

    @Test
    fun insertAllTest() {
        orma.selectFromQiitaTag().toList().size.should be 0

        dao.insertAll(listOf())

        orma.selectFromQiitaTag().toList().size.should be 0

        val size = 10
        val expectTags = Array(size) { it.toString() }
                .map { QiitaTag(it) }
                .toList()

        dao.insertAll(expectTags)

        val actualTags = orma.selectFromQiitaTag().toList()
        actualTags.size.should be expectTags.size
        actualTags.forEachIndexed { i, actual ->
            val expect = expectTags[i]

            actual.name.should be expect.name
            actual.subscribed.should be expect.subscribed
        }
    }

    @Test
    fun findAllTest() {
        orma.selectFromQiitaTag().toList().size.should be 0

        val size = 10
        val expects = Array(size) { it.toString() }
                .map { QiitaTag(it) }
                .toList()
        orma.prepareInsertIntoQiitaTag().executeAll(expects)

        val subscriber = TestSubscriber<List<QiitaTag>>()
        dao.findAll().subscribe(subscriber)
        subscriber.assertNoErrors()
        subscriber.assertCompleted()
        subscriber.onNextEvents.size.should be 1
        subscriber.onNextEvents[0].forEachIndexed { i, actual ->
            val expect = expects[i]

            actual.name.should be expect.name
            actual.subscribed.should be expect.subscribed
        }
    }

    @Test
    fun findSubscribedTest() {
        orma.selectFromQiitaTag().toList().size.should be 0

        val subscribedRange = 0..4
        val notSubscribedRange = 5..9
        val subscribedTags = mutableListOf<QiitaTag>()
        val notSubscribedTags = mutableListOf<QiitaTag>()
        val tags = mutableListOf<QiitaTag>()
        subscribedRange.forEach { subscribedTags.add(QiitaTag(it.toString(), true)) }
        notSubscribedRange.forEach { notSubscribedTags.add(QiitaTag(it.toString(), false)) }
        tags.addAll(subscribedTags)
        tags.addAll(notSubscribedTags)

        orma.prepareInsertIntoQiitaTag().executeAll(tags)

        val subscriber = TestSubscriber<List<QiitaTag>>()
        dao.findSubscribed().subscribe(subscriber)
        subscriber.assertNoErrors()
        subscriber.assertCompleted()
        subscriber.onNextEvents.size.should be 1
        subscriber.onNextEvents[0].forEachIndexed { i, actual ->
            val expect = subscribedTags[i]

            actual.name.should be expect.name
            actual.subscribed.should be expect.subscribed
        }
    }

}