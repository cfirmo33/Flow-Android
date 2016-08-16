package com.yuyakaido.android.flow.presentation.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.presentation.item.HatenaItem

/**
 * Created by yuyakaido on 8/16/16.
 */
class HatenaHomeFragment : BaseFragment(), TabLayout.OnTabSelectedListener {

    companion object {

        fun newInstance(): Fragment {
            return HatenaHomeFragment()
        }

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_hatena_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val tabLayout = view?.findViewById(R.id.fragment_hatena_home_tab_layout) as TabLayout
        tabLayout.addTab(tabLayout.newTab().setTag(HatenaItem.Hot).setText(HatenaItem.Hot.titleResId))
        tabLayout.addTab(tabLayout.newTab().setTag(HatenaItem.New).setText(HatenaItem.New.titleResId))
        tabLayout.addOnTabSelectedListener(this)

        replaceFragment(HatenaItem.Hot)
    }

    override fun onTabReselected(tab: TabLayout.Tab?) { }

    override fun onTabUnselected(tab: TabLayout.Tab?) { }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        tab?.let {
            replaceFragment(tab.tag as HatenaItem)
        }
    }

    fun replaceFragment(item: HatenaItem) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_hatena_home_fragment_container, item.fragment())
        transaction.commit()
    }

}