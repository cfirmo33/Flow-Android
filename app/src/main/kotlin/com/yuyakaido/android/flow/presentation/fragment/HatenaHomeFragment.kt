package com.yuyakaido.android.flow.presentation.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.roughike.bottombar.BottomBar
import com.roughike.bottombar.OnMenuTabClickListener
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.presentation.item.HatenaItem

/**
 * Created by yuyakaido on 8/16/16.
 */
class HatenaHomeFragment : BaseFragment(), OnMenuTabClickListener {

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

        val bottomBar = view?.findViewById(R.id.fragment_hatena_home_bottom_bar) as BottomBar
        bottomBar.setItems(R.menu.menu_hatena)
        bottomBar.setOnMenuTabClickListener(this)
    }

    override fun onMenuTabReSelected(menuItemId: Int) { }

    override fun onMenuTabSelected(menuItemId: Int) {
        replaceFragment(HatenaItem.fromMenuId(menuItemId))
    }

    fun replaceFragment(item: HatenaItem) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_hatena_home_fragment_container, item.fragment())
        transaction.commit()
    }

}