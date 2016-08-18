package com.yuyakaido.android.flow.util

import android.support.v7.widget.LinearLayoutManager
import com.jakewharton.rxbinding.support.v7.widget.RecyclerViewScrollEvent
import rx.functions.Func1

/**
 * Created by yuyakaido on 7/31/16.
 */
class RecyclerViewUtil {

    companion object {

        fun shouldPaginate(manager: LinearLayoutManager): Func1<RecyclerViewScrollEvent, Boolean> {
            return Func1 { manager.itemCount - 1 == manager.findLastVisibleItemPosition() }
        }

    }

}