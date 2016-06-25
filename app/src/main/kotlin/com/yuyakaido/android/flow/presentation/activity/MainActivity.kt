package com.yuyakaido.android.flow.presentation.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.domain.MenthasCategory
import com.yuyakaido.android.flow.infra.repository.MenthasRepository
import com.yuyakaido.android.flow.presentation.adapter.ArticlePagerAdapter
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchCategories()
    }

    private fun fetchCategories() {
        MenthasRepository.getCategories()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ categories -> initViewPager(categories) })
    }

    private fun initViewPager(categories: List<MenthasCategory>) {
        val viewPager = findViewById(R.id.activity_main_view_pager) as ViewPager
        viewPager.adapter = ArticlePagerAdapter(supportFragmentManager, categories)

        val tabLayout = findViewById(R.id.activity_main_tab_layout) as TabLayout
        tabLayout.setupWithViewPager(viewPager)
    }

}
