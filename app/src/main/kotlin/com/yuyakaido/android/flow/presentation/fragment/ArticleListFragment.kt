package com.yuyakaido.android.flow.presentation.fragment

import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.domain.Article
import com.yuyakaido.android.flow.domain.Category
import com.yuyakaido.android.flow.domain.Site
import com.yuyakaido.android.flow.presentation.adapter.ArticleListAdapter
import com.yuyakaido.android.flow.util.ErrorHandler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

/**
 * Created by yuyakaido on 6/20/16.
 */
class ArticleListFragment : BaseFragment() {

    private val subscriptions: CompositeSubscription = CompositeSubscription()

    private lateinit var site: Site
    private lateinit var category: Category
    private lateinit var adapter: ArticleListAdapter

    companion object {
        val ARGS_SITE = "ARGS_SITE"
        val ARGS_CATEGORY = "ARGS_CATEGORY"

        fun newInstance(site: Site, category: Category): Fragment {
            val args = Bundle()
            args.putSerializable(ARGS_SITE, site)
            args.putSerializable(ARGS_CATEGORY, category)
            val fragment = ArticleListFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_article_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        site = arguments.getSerializable(ARGS_SITE) as Site
        category = arguments.getSerializable(ARGS_CATEGORY) as Category
        adapter = ArticleListAdapter(context, mutableListOf())

        val listView = view?.findViewById(R.id.fragment_article_list_list_view) as ListView
        listView.adapter = adapter
        listView.setOnItemClickListener {
            adapterView, view, i, l -> startWebBrowser(adapter.getItem(i))
        }

        fetchArticles()
    }

    private fun fetchArticles() {
        subscriptions.add(site.articles(category)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { initListView(it) },
                        { ErrorHandler.handle(it) }))
    }

    private fun initListView(articles: List<Article>) {
        adapter.addAll(articles)
        adapter.notifyDataSetChanged()
    }

    private fun startWebBrowser(article: Article) {
        val intent = CustomTabsIntent.Builder().build()
        intent.launchUrl(activity, Uri.parse(article.url()))
    }

}