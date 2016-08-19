package com.yuyakaido.android.flow.util

import android.support.v7.widget.LinearLayoutManager
import com.sys1yagi.kmockito.invoked
import com.sys1yagi.kmockito.mock
import com.taroid.knit.should
import com.yuyakaido.android.flow.misc.FlowTest
import org.junit.Test

/**
 * Created by yuyakaido on 8/19/16.
 */
class RecyclerViewUtilTest : FlowTest() {

    @Test
    fun shouldPaginateTest() {
        val manager = mock<LinearLayoutManager>()

        manager.itemCount.invoked.thenReturn(0)
        manager.findLastVisibleItemPosition().invoked.thenReturn(0)
        RecyclerViewUtil.shouldPaginate(manager).call(null).should be false

        manager.itemCount.invoked.thenReturn(10)
        manager.findLastVisibleItemPosition().invoked.thenReturn(5)
        RecyclerViewUtil.shouldPaginate(manager).call(null).should be false

        manager.itemCount.invoked.thenReturn(10)
        manager.findLastVisibleItemPosition().invoked.thenReturn(9)
        RecyclerViewUtil.shouldPaginate(manager).call(null).should be true
    }

}