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
import com.yuyakaido.android.flow.presentation.adapter.QiitaPagerAdapter
import com.yuyakaido.android.flow.presentation.item.QiitaSubscription
import com.yuyakaido.android.flow.presentation.viewmodel.QiitaPostViewModel
import com.yuyakaido.android.flow.util.ErrorHandler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

/**
 * Created by yuyakaido on 8/15/16.
 */
class QiitaPostFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: QiitaPostViewModel

    private val subscriptions = CompositeSubscription()

    companion object {
        fun newInstance(): Fragment {
            return QiitaPostFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_qiita_post, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Flow.getAppComponent().newQiitaPostComponent().inject(this)

        subscriptions.add(viewModel.qiitaSubscriptions
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { showProgressBar() }
                .doOnUnsubscribe { hideProgressBar() }
                .subscribe({
                    setQiitaSubscriptions(it)
                }, {
                    ErrorHandler.handle(it)
                }))
    }

    override fun onDestroyView() {
        subscriptions.unsubscribe()
        super.onDestroyView()
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