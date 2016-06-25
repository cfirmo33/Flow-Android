package com.yuyakaido.android.flow.presentation.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.yuyakaido.android.flow.domain.MenthasCategory
import com.yuyakaido.android.flow.presentation.fragment.ArticleFragment

/**
 * Created by yuyakaido on 6/20/16.
 */
class ArticlePagerAdapter(val fragmentManager: FragmentManager, val menthasCategories: List<MenthasCategory>) : FragmentPagerAdapter(fragmentManager) {

    override fun getPageTitle(position: Int): CharSequence? {
        return menthasCategories[position].name
    }

    override fun getCount(): Int {
        return menthasCategories.size
    }

    override fun getItem(position: Int): Fragment? {
        return ArticleFragment.newInstance(menthasCategories[position])
    }

}