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
import com.yuyakaido.android.flow.presentation.adapter.QiitaPagerAdapter
import com.yuyakaido.android.flow.presentation.item.QiitaSubscription
import com.yuyakaido.android.flow.presentation.presenter.QiitaPostPresenter

/**
 * Created by yuyakaido on 8/15/16.
 */
class QiitaPostFragment : BaseFragment() {

    companion object {

        fun newInstance(): Fragment {
            return QiitaPostFragment()
        }

    }

    lateinit var presenter: QiitaPostPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_qiita_post, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = QiitaPostPresenter(this)
        presenter.onCreate()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    fun setQiitaSubscriptions(subscriptions: List<QiitaSubscription>) {
        val viewPager = view?.findViewById(R.id.fragment_qiita_post_view_pager) as ViewPager
        viewPager.adapter = QiitaPagerAdapter(childFragmentManager, subscriptions)

        val tabLayout = view?.findViewById(R.id.fragment_qiita_post_tab_layout) as TabLayout
        tabLayout.setupWithViewPager(viewPager)
    }

    fun showProgressBar() {
        val progressBar = view?.findViewById(R.id.fragment_qiita_post_progress_bar) as ProgressBar
        progressBar.visibility = View.VISIBLE
    }

    fun hideProgressBar() {
        val progressBar = view?.findViewById(R.id.fragment_qiita_post_progress_bar) as ProgressBar
        progressBar.visibility = View.GONE
    }

}