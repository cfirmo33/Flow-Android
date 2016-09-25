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
import com.yuyakaido.android.flow.app.Flow
import com.yuyakaido.android.flow.di.module.GetCategoryModule
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.domain.entity.Site
import com.yuyakaido.android.flow.presentation.adapter.CategoryPagerAdapter
import com.yuyakaido.android.flow.presentation.viewmodel.CategoryPagerViewModel
import com.yuyakaido.android.flow.util.ErrorHandler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

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
    private val subscriptions = CompositeSubscription()

    @Inject
    lateinit var viewModel: CategoryPagerViewModel

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_category_pager, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Flow.getAppComponent().newCategoryPagerComponent(GetCategoryModule(site)).inject(this)

        subscriptions.add(viewModel.categories
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { showProgressBar() }
                .doOnUnsubscribe { hideProgressBar() }
                .subscribe({
                    setCategories(it)
                }, {
                    ErrorHandler.handle(it)
                }))
    }

    override fun onDestroyView() {
        subscriptions.unsubscribe()
        super.onDestroyView()
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