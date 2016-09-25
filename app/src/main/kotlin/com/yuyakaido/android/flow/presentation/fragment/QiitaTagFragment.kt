package com.yuyakaido.android.flow.presentation.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.app.Flow
import com.yuyakaido.android.flow.domain.entity.QiitaTag
import com.yuyakaido.android.flow.presentation.adapter.ItemClickListener
import com.yuyakaido.android.flow.presentation.adapter.QiitaTagAdapter
import com.yuyakaido.android.flow.presentation.viewmodel.QiitaTagViewModel
import com.yuyakaido.android.flow.util.ErrorHandler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by yuyakaido on 8/15/16.
 */
class QiitaTagFragment : BaseFragment(), ItemClickListener<QiitaTag> {

    companion object {
        fun newInstance(): Fragment {
            return QiitaTagFragment()
        }
    }

    private lateinit var adapter: QiitaTagAdapter

    @Inject
    lateinit var viewModel: QiitaTagViewModel

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_qiita_tag, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Flow.getAppComponent().newQiitaTagComponent().inject(this)

        initialize()

        viewModel.tags
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { showProgressBar() }
                .doOnUnsubscribe { hideProgressBar() }
                .subscribe({
                    addQiitaTags(it)
                }, {
                    ErrorHandler.handle(it)
                })
    }

    override fun onItemClick(item: QiitaTag) {
        viewModel.putTrigger.onNext(item)
    }

    fun initialize() {
        adapter = QiitaTagAdapter(context, mutableListOf(), this)

        val recyclerView = view?.findViewById(R.id.fragment_qiita_tag_recycler_view) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    fun addQiitaTags(tags: List<QiitaTag>) {
        adapter.addAll(tags)
        adapter.notifyDataSetChanged()
    }

    fun showProgressBar() {
        val progressBar = view?.findViewById(R.id.fragment_qiita_tag_progress_bar) as ProgressBar
        progressBar.visibility = View.VISIBLE
    }

    fun hideProgressBar() {
        val progressBar = view?.findViewById(R.id.fragment_qiita_tag_progress_bar) as ProgressBar
        progressBar.visibility = View.GONE
    }

}