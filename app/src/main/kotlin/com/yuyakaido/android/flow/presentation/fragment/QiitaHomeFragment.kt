package com.yuyakaido.android.flow.presentation.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.roughike.bottombar.BottomBar
import com.roughike.bottombar.OnMenuTabClickListener
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.presentation.item.QiitaItem

/**
 * Created by yuyakaido on 8/15/16.
 */
class QiitaHomeFragment : BaseFragment(), OnMenuTabClickListener {

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

        val bottomBar = view?.findViewById(R.id.fragment_qiita_home_bottom_bar) as BottomBar
        bottomBar.setItems(R.menu.menu_qiita)
        bottomBar.setOnMenuTabClickListener(this)
    }

    override fun onMenuTabReSelected(menuItemId: Int) { }

    override fun onMenuTabSelected(menuItemId: Int) {
        replaceFragment(QiitaItem.fromMenuId(menuItemId))
    }

    fun replaceFragment(item: QiitaItem) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_qiita_home_fragment_container, item.fragment())
        transaction.commit()
    }

}