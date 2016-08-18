package com.yuyakaido.android.flow.misc

import android.content.Context
import android.os.Build
import com.yuyakaido.android.flow.BuildConfig
import com.yuyakaido.android.flow.app.TestFlow
import org.junit.After
import org.junit.Before
import org.junit.Ignore
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

/**
 * Created by yuyakaido on 7/30/16.
 */
@Ignore
@RunWith(RobolectricTestRunner::class)
@Config(application = TestFlow::class,
        constants = BuildConfig::class,
        sdk = intArrayOf(Build.VERSION_CODES.M))
open class FlowTest {

    @Before
    open fun setUp() {}

    @After
    open fun tearDown() {}

    fun getContext(): Context {
        return RuntimeEnvironment.application
    }

}