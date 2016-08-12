package com.yuyakaido.android.flow.presentation.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.yuyakaido.android.flow.R

/**
 * Created by yuyakaido on 7/22/16.
 */
open class BaseActivity : AppCompatActivity() {

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        val toolbar = getToolbar()
        toolbar.let {
            setSupportActionBar(toolbar)
            val actionBar = supportActionBar
            actionBar?.let {
                actionBar.setDisplayHomeAsUpEnabled(true)
            }
        }
    }

    fun setTitle(title: String) {
        val toolbar = getToolbar()
        toolbar?.title = title
    }

    fun getToolbar(): Toolbar? {
        return findViewById(R.id.toolbar) as Toolbar
    }

}