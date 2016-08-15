package com.yuyakaido.android.flow.presentation.item

import android.support.v4.app.Fragment
import com.yuyakaido.android.flow.domain.entity.QiitaCategory
import com.yuyakaido.android.flow.domain.entity.QiitaTag
import com.yuyakaido.android.flow.domain.entity.Site
import com.yuyakaido.android.flow.presentation.fragment.ArticleListFragment

/**
 * Created by yuyakaido on 8/15/16.
 */
class QiitaSubscription(val isAll: Boolean, val tag: QiitaTag?) {

    fun title(): String {
        return if (isAll) {
            "All"
        } else {
            tag!!.name
        }
    }

    fun fragment(): Fragment {
        return if (isAll) {
            ArticleListFragment.newInstance(Site.Qiita, QiitaCategory(""))
        } else {
            ArticleListFragment.newInstance(Site.Qiita, QiitaCategory(""))
        }
    }

}