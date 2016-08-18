package com.yuyakaido.android.flow.infra.dao

import com.yuyakaido.android.flow.domain.entity.OrmaDatabase
import com.yuyakaido.android.flow.misc.FlowTest
import org.junit.Before
import org.junit.Ignore

/**
 * Created by yuyakaido on 8/18/16.
 */
@Ignore
open class DaoTest : FlowTest() {

    lateinit var orma: OrmaDatabase

    @Before
    override fun setUp() {
        super.setUp()
        orma = OrmaDatabase.builder(getContext())
                .name(null)
                .build()
    }

}