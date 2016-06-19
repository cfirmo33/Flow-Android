package com.yuyakaido.android.flow

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById(R.id.activity_main_view_pager) as ViewPager
        val categories = mutableListOf<Category>()
        for (i in 0..2) {
            categories.add(Category(i.toString()))
        }
        viewPager.adapter = ArticlePagerAdapter(supportFragmentManager, categories)

        val tabLayout = findViewById(R.id.activity_main_tab_layout) as TabLayout
        tabLayout.setupWithViewPager(viewPager)
    }

}
