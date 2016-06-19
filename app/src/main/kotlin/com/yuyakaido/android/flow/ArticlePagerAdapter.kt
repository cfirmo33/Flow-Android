package com.yuyakaido.android.flow

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by yuyakaido on 6/20/16.
 */
class ArticlePagerAdapter(val fragmentManager: FragmentManager, val categories: List<Category>) : FragmentPagerAdapter(fragmentManager) {

    override fun getPageTitle(position: Int): CharSequence? {
        return categories[position].name
    }

    override fun getCount(): Int {
        return categories.size
    }

    override fun getItem(position: Int): Fragment? {
        return ArticleFragment.newInstance(categories[position])
    }

}