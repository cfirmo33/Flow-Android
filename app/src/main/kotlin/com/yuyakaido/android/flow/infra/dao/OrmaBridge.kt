package com.yuyakaido.android.flow.infra.dao

import android.content.Context
import com.github.gfx.android.orma.AccessThreadConstraint
import com.yuyakaido.android.flow.domain.entity.OrmaDatabase

/**
 * Created by yuyakaido on 8/15/16.
 */
class OrmaBridge(context: Context) {

    val orma: OrmaDatabase

    init {
        orma = OrmaDatabase.builder(context)
                .readOnMainThread(AccessThreadConstraint.FATAL)
                .writeOnMainThread(AccessThreadConstraint.FATAL)
                .build()
    }

}
