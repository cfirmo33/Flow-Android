package com.yuyakaido.android.flow.util

import com.jakewharton.rxbinding.widget.AbsListViewScrollEvent
import rx.functions.Func1

/**
 * Created by yuyakaido on 7/31/16.
 */
class ListViewUtil {

    companion object {

        fun shouldPaginate(): Func1<AbsListViewScrollEvent, Boolean> {
            return Func1 { shouldPaginate(it) }
        }

        fun shouldPaginate(event: AbsListViewScrollEvent): Boolean {
            return event.totalItemCount() > 0
                    && event.firstVisibleItem() + event.visibleItemCount() == event.totalItemCount()
        }

    }

}