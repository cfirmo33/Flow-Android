package com.yuyakaido.android.flow.presentation.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.presentation.item.QiitaItem

/**
 * Created by yuyakaido on 8/15/16.
 */
class QiitaHomeFragment : BaseFragment(), TabLayout.OnTabSelectedListener {

    companion object {

        fun newInstance(): Fragment {
            return QiitaHomeFragment()
        }

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_qiita_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val tabLayout = view?.findViewById(R.id.fragment_qiita_home_tab_layout) as TabLayout
        tabLayout.addTab(tabLayout.newTab().setTag(QiitaItem.Post).setText(QiitaItem.Post.stringResId))
        tabLayout.addTab(tabLayout.newTab().setTag(QiitaItem.Tag).setText(QiitaItem.Tag.stringResId))
        tabLayout.addOnTabSelectedListener(this)

        replaceFragment(QiitaItem.Post)
    }

    override fun onTabReselected(tab: TabLayout.Tab?) { }

    override fun onTabUnselected(tab: TabLayout.Tab?) { }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        tab?.let {
            replaceFragment(tab.tag as QiitaItem)
        }
    }

    fun replaceFragment(item: QiitaItem) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_qiita_home_fragment_container, item.fragment())
        transaction.commit()
    }

}