package com.yuyakaido.android.flow.presentation.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.domain.entity.Site
import com.yuyakaido.android.flow.presentation.adapter.CategoryPagerAdapter
import com.yuyakaido.android.flow.presentation.presenter.MenthasCategoryPresenter

/**
 * Created by yuyakaido on 7/23/16.
 */
class MenthasCategoryFragment : BaseFragment() {

    companion object {
        fun newInstance() : Fragment {
            return MenthasCategoryFragment()
        }
    }

    lateinit var presenter: MenthasCategoryPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_menthas_category, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = MenthasCategoryPresenter(this)
        presenter.onCreate()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    fun setCategories(categories: List<Category>) {
        val viewPager = view?.findViewById(R.id.fragment_menthas_category_view_pager) as ViewPager
        viewPager.adapter = CategoryPagerAdapter(childFragmentManager, Site.Menthas, categories)

        val tabLayout = view?.findViewById(R.id.fragment_menthas_category_tab_layout) as TabLayout
        tabLayout.setupWithViewPager(viewPager)
    }

    fun showProgressBar() {
        val progressBar = view?.findViewById(R.id.fragment_menthas_category_progress_bar) as ProgressBar
        progressBar.visibility = View.VISIBLE
    }

    fun hideProgressBar() {
        val progressBar = view?.findViewById(R.id.fragment_menthas_category_progress_bar) as ProgressBar
        progressBar.visibility = View.GONE
    }

}