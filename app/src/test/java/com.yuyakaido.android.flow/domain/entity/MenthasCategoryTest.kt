package com.yuyakaido.android.flow.domain.entity

import com.taroid.knit.should
import com.yuyakaido.android.flow.misc.FlowTest
import org.junit.Test

/**
 * Created by yuyakaido on 7/31/16.
 */
class MenthasCategoryTest : FlowTest() {

    @Test
    fun equalsTest() {
        val java = MenthasCategory("java")
        val kotlin = MenthasCategory("kotlin")
        val altJava = MenthasCategory("java")

        java.equals(java).should be true
        java.equals(kotlin).should be false
        java.equals(altJava).should be true
    }

}