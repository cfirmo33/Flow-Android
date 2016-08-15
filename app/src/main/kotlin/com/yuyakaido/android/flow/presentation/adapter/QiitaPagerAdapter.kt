package com.yuyakaido.android.flow.presentation.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.yuyakaido.android.flow.presentation.item.QiitaSubscription

/**
 * Created by yuyakaido on 8/15/16.
 */
class QiitaPagerAdapter(fragmentManager: FragmentManager, val subscriptions: List<QiitaSubscription>) : FragmentPagerAdapter(fragmentManager) {

    override fun getPageTitle(position: Int): CharSequence? {
        return subscriptions[position].title()
    }

    override fun getCount(): Int {
        return subscriptions.size
    }

    override fun getItem(position: Int): Fragment? {
        return subscriptions[position].fragment()
    }

}