package com.yuyakaido.android.flow.presentation.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.domain.entity.Site
import com.yuyakaido.android.flow.presentation.fragment.ArticleListFragment

/**
 * Created by yuyakaido on 6/20/16.
 */
class CategoryPagerAdapter(fragmentManager: FragmentManager, val site: Site, val categories: List<Category>) : FragmentPagerAdapter(fragmentManager) {

    override fun getPageTitle(position: Int): CharSequence? {
        return categories[position].name()
    }

    override fun getCount(): Int {
        return categories.size
    }

    override fun getItem(position: Int): Fragment? {
        return ArticleListFragment.newInstance(site, categories[position])
    }

}