package com.yuyakaido.android.flow.presentation.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.app.Flow
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.domain.entity.Site
import com.yuyakaido.android.flow.domain.usecase.GetCategoryUseCase
import com.yuyakaido.android.flow.presentation.adapter.CategoryPagerAdapter
import com.yuyakaido.android.flow.util.ErrorHandler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

/**
 * Created by yuyakaido on 7/23/16.
 */
class MenthasCategoryFragment : BaseFragment() {

    companion object {

        fun newInstance() : Fragment {
            return MenthasCategoryFragment()
        }

    }

    private val subscriptions = CompositeSubscription()

    @Inject
    lateinit var getCategoryUseCase: GetCategoryUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Flow.getAppComponent(context)
                .newPresentationComponent()
                .newMenthasCategoryComponent()
                .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_menthas_category, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fetchCategories()
    }

    override fun onDestroy() {
        subscriptions.unsubscribe()
        super.onDestroy()
    }

    private fun fetchCategories() {
        subscriptions.add(getCategoryUseCase.getCategories()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { initViewPager(it) },
                        { ErrorHandler.handle(it) }))
    }

    private fun initViewPager(categories: List<Category>) {
        view?.let {
            val viewPager = it.findViewById(R.id.fragment_menthas_category_view_pager) as ViewPager
            viewPager.adapter = CategoryPagerAdapter(childFragmentManager, Site.Menthas, categories)

            val tabLayout = it.findViewById(R.id.fragment_menthas_category_tab_layout) as TabLayout
            tabLayout.setupWithViewPager(viewPager)
        }
    }

}