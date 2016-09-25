package com.yuyakaido.android.flow.presentation.misc

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.jakewharton.rxbinding.support.v7.widget.scrollEvents
import com.yuyakaido.android.flow.util.ErrorHandler
import com.yuyakaido.android.flow.util.RecyclerViewUtil
import rx.Subscription
import rx.subjects.PublishSubject

/**
 * Created by yuyakaido on 8/19/16.
 * http://sys1yagi.hatenablog.com/entry/2016/02/23/185543
 */
class PaginationHandler(
        private val recyclerView: RecyclerView,
        private val linearLayoutManager: LinearLayoutManager) {

    private val trigger = PublishSubject.create<Void>()
    private var subscription: Subscription? = null

    fun trigger(): PublishSubject<Void> = trigger

    fun subscribe() {
        subscription?.unsubscribe()
        subscription = recyclerView.scrollEvents()
                .filter(RecyclerViewUtil.shouldPaginate(linearLayoutManager))
                .subscribe({
                    trigger.onNext(null)
                }, {
                    ErrorHandler.handle(it)
                })
    }

    fun unsubscribe() {
        subscription?.unsubscribe()
        subscription = null
    }

}