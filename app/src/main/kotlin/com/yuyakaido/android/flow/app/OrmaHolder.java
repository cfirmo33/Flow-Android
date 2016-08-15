package com.yuyakaido.android.flow.app;

import android.content.Context;

import com.github.gfx.android.orma.AccessThreadConstraint;
import com.yuyakaido.android.flow.domain.entity.OrmaDatabase;

/**
 * Created by yuyakaido on 8/15/16.
 */
public class OrmaHolder {

    private static OrmaDatabase orma;

    public static synchronized OrmaDatabase getInstance(Context context) {
        if (orma == null) {
            orma = OrmaDatabase.builder(context)
                    .readOnMainThread(AccessThreadConstraint.FATAL)
                    .writeOnMainThread(AccessThreadConstraint.FATAL)
                    .build();
        }
        return orma;
    }

}
