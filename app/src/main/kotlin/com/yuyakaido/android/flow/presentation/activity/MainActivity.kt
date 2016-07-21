package com.yuyakaido.android.flow.presentation.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.domain.MenthasCategory
import com.yuyakaido.android.flow.infra.repository.MenthasRepository
import com.yuyakaido.android.flow.presentation.adapter.ArticlePagerAdapter
import com.yuyakaido.android.flow.util.ErrorHandler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

class MainActivity : BaseActivity() {

    private val subscriptions: CompositeSubscription = CompositeSubscription()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchCategories()
    }

    override fun onDestroy() {
        subscriptions.unsubscribe()
        super.onDestroy()
    }

    private fun fetchCategories() {
        subscriptions.add(MenthasRepository.getCategories()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { initViewPager(it) },
                        { ErrorHandler.handle(it) }))
    }

    private fun initViewPager(categories: List<MenthasCategory>) {
        val viewPager = findViewById(R.id.activity_main_view_pager) as ViewPager
        viewPager.adapter = ArticlePagerAdapter(supportFragmentManager, categories)

        val tabLayout = findViewById(R.id.activity_main_tab_layout) as TabLayout
        tabLayout.setupWithViewPager(viewPager)
    }

}
