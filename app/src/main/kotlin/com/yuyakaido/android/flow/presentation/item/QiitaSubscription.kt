package com.yuyakaido.android.flow.presentation.item

import android.support.v4.app.Fragment
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.app.Flow
import com.yuyakaido.android.flow.domain.entity.QiitaTag
import com.yuyakaido.android.flow.presentation.fragment.ArticleListFragment
import java.io.Serializable

/**
 * Created by yuyakaido on 8/15/16.
 */
class QiitaSubscription(val isAll: Boolean, val tag: QiitaTag?) : Serializable {

    fun title(): String {
        return if (isAll) {
            Flow.getContext().getString(R.string.qiita_all)
        } else {
            tag!!.name
        }
    }

    fun fragment(): Fragment {
        return ArticleListFragment.newQiitaInstance(this)
    }

}