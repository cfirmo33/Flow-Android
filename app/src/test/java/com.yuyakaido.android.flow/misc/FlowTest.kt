package com.yuyakaido.android.flow.misc

import android.os.Build
import com.yuyakaido.android.flow.BuildConfig
import com.yuyakaido.android.flow.app.TestFlow
import org.junit.Ignore
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Created by yuyakaido on 7/30/16.
 */
@Ignore
@RunWith(RobolectricTestRunner::class)
@Config(application = TestFlow::class,
        constants = BuildConfig::class,
        sdk = intArrayOf(Build.VERSION_CODES.M))
open class FlowTest {}