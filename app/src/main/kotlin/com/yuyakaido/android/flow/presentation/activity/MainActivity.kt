package com.yuyakaido.android.flow.presentation.activity

import android.content.res.Configuration
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Gravity
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.presentation.item.NavigationItem

class MainActivity : BaseActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.activity_main_drawer_layout) as DrawerLayout
        navigationView = findViewById(R.id.activity_main_navigation_view) as NavigationView

        replaceFragment(NavigationItem.Menthas)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, getToolbar(), R.string.app_name, R.string.app_name)
        actionBarDrawerToggle.syncState()

        drawerLayout.addDrawerListener(actionBarDrawerToggle)

        navigationView.setNavigationItemSelectedListener {
            drawerLayout.closeDrawer(Gravity.START)
            it.isChecked = true
            replaceFragment(NavigationItem.fromMenuId(it.itemId))
            false
        }
    }

    override fun onDestroy() {
        drawerLayout.removeDrawerListener(actionBarDrawerToggle)
        super.onDestroy()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        actionBarDrawerToggle.onConfigurationChanged(newConfig)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.START)) {
            drawerLayout.closeDrawer(Gravity.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun replaceFragment(item: NavigationItem) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.activity_main_fragment_container, item.fragment())
        transaction.commit()

        setTitle(getString(item.titleResId))
    }

}
