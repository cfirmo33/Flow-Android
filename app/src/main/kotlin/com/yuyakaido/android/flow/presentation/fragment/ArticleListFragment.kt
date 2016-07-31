package com.yuyakaido.android.flow.presentation.fragment

import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.domain.entity.Site
import com.yuyakaido.android.flow.presentation.adapter.ArticleListAdapter
import com.yuyakaido.android.flow.presentation.presenter.ArticleListPresenter

/**
 * Created by yuyakaido on 6/20/16.
 */
class ArticleListFragment : BaseFragment() {

    private val site by lazy { arguments.getSerializable(ARGS_SITE) as Site }
    private val category by lazy { arguments.getSerializable(ARGS_CATEGORY) as Category }

    private lateinit var presenter: ArticleListPresenter
    private lateinit var adapter: ArticleListAdapter

    companion object {
        private val ARGS_SITE = "ARGS_SITE"
        private val ARGS_CATEGORY = "ARGS_CATEGORY"

        fun newInstance(site: Site, category: Category): Fragment {
            val args = Bundle()
            args.putSerializable(ARGS_SITE, site)
            args.putSerializable(ARGS_CATEGORY, category)
            val fragment = ArticleListFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_article_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = ArticleListPresenter(this, site, category)
        presenter.onCreate()
    }

    fun initialize() {
        adapter = ArticleListAdapter(context, mutableListOf())

        val swipeRefreshLayout = view?.findViewById(R.id.fragment_article_list_swipe_refresh_layout) as SwipeRefreshLayout
        swipeRefreshLayout.setOnRefreshListener { presenter.refresh() }

        val listView = view?.findViewById(R.id.fragment_article_list_list_view) as ListView
        listView.adapter = adapter
        listView.setOnItemClickListener {
            adapterView, view, i, l -> startWebBrowser(adapter.getItem(i))
        }

        presenter.registerScrollEvent(listView)
    }

    fun clearArticles() {
        adapter.clear()
        adapter.notifyDataSetChanged()
    }

    fun addArticles(articles: List<Article>) {
        adapter.addAll(articles)
        adapter.notifyDataSetChanged()
    }

    fun startWebBrowser(article: Article) {
        val intent = CustomTabsIntent.Builder().build()
        intent.launchUrl(activity, Uri.parse(article.url()))
    }

    fun showProgressBar() {
        val swipeRefreshLayout = view?.findViewById(R.id.fragment_article_list_swipe_refresh_layout) as SwipeRefreshLayout
        swipeRefreshLayout.isRefreshing = true
    }

    fun hideProgressBar() {
        val swipeRefreshLayout = view?.findViewById(R.id.fragment_article_list_swipe_refresh_layout) as SwipeRefreshLayout
        swipeRefreshLayout.isRefreshing = false
    }

}