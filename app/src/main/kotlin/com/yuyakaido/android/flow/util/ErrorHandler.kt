package com.yuyakaido.android.flow.util

import android.util.Log
import com.yuyakaido.android.flow.BuildConfig

/**
 * Created by yuyakaido on 7/17/16.
 */
class ErrorHandler {

    companion object {

        fun handle(e: Throwable) {
            if (BuildConfig.DEBUG) {
                Log.e("Error", e.message)
            }
        }

    }

}