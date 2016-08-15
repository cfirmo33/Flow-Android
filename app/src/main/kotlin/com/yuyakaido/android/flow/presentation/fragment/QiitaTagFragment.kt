package com.yuyakaido.android.flow.presentation.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.domain.entity.QiitaTag
import com.yuyakaido.android.flow.presentation.adapter.QiitaTagAdapter
import com.yuyakaido.android.flow.presentation.presenter.QiitaTagPresenter

/**
 * Created by yuyakaido on 8/15/16.
 */
class QiitaTagFragment : BaseFragment() {

    companion object {

        fun newInstance(): Fragment {
            return QiitaTagFragment()
        }

    }

    private lateinit var presenter: QiitaTagPresenter
    private lateinit var adapter: QiitaTagAdapter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_qiita_tag, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = QiitaTagPresenter(this)
        presenter.onCreate()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    fun initialize() {
        adapter = QiitaTagAdapter(context, mutableListOf())

        val listView = view?.findViewById(R.id.fragment_qiita_tag_list_view) as ListView
        listView.adapter = adapter
    }

    fun addTags(tags: List<QiitaTag>) {
        adapter.addAll(tags)
        adapter.notifyDataSetChanged()
    }

}