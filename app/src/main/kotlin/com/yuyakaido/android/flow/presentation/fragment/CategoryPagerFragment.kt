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
import com.yuyakaido.android.flow.presentation.presenter.CategoryPagerPresenter

/**
 * Created by yuyakaido on 7/23/16.
 */
class CategoryPagerFragment : BaseFragment() {

    companion object {

        private val ARGS_SITE = "ARGS_SITE"

        fun newInstance(site: Site) : Fragment {
            val args = Bundle()
            args.putSerializable(ARGS_SITE, site)
            val fragment = CategoryPagerFragment()
            fragment.arguments = args
            return fragment
        }

    }

    private val site by lazy { arguments.getSerializable(ARGS_SITE) as Site }

    lateinit var presenter: CategoryPagerPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_category_pager, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = CategoryPagerPresenter(this, site)
        presenter.onCreate()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    fun setCategories(categories: List<Category>) {
        val viewPager = view?.findViewById(R.id.fragment_category_pager_view_pager) as ViewPager
        viewPager.adapter = CategoryPagerAdapter(childFragmentManager, site, categories)

        val tabLayout = view?.findViewById(R.id.fragment_category_pager_tab_layout) as TabLayout
        tabLayout.setupWithViewPager(viewPager)
    }

    fun showProgressBar() {
        val progressBar = view?.findViewById(R.id.fragment_category_pager_progress_bar) as ProgressBar
        progressBar.visibility = View.VISIBLE
    }

    fun hideProgressBar() {
        val progressBar = view?.findViewById(R.id.fragment_category_pager_progress_bar) as ProgressBar
        progressBar.visibility = View.GONE
    }

}