package com.yuyakaido.android.flow.presentation.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.domain.entity.QiitaCategory
import com.yuyakaido.android.flow.domain.entity.Site

/**
 * Created by yuyakaido on 7/23/16.
 */
class QiitaFragment : BaseFragment() {

    companion object {

        fun newInstance(): Fragment {
            return QiitaFragment()
        }

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_qiita, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val site = Site.Qiita
        val category = QiitaCategory("android")

        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_qiita_fragment_container, ArticleListFragment.newInstance(site, category))
        transaction.commit()
    }

}