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
import com.yuyakaido.android.flow.app.Flow
import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.domain.entity.Site
import com.yuyakaido.android.flow.domain.usecase.GetArticleUseCase
import com.yuyakaido.android.flow.presentation.adapter.ArticleListAdapter
import com.yuyakaido.android.flow.util.ErrorHandler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

/**
 * Created by yuyakaido on 6/20/16.
 */
class ArticleListFragment : BaseFragment() {

    private val subscriptions: CompositeSubscription = CompositeSubscription()

    private val site: Site by lazy { arguments.getSerializable(ARGS_SITE) as Site }
    private val category: Category by lazy { arguments.getSerializable(ARGS_CATEGORY) as Category }
    private lateinit var adapter: ArticleListAdapter

    @Inject
    lateinit var getArticleUseCase: GetArticleUseCase

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Flow.getAppComponent(context)
                .newPresentationComponent()
                .newArticleListComponent()
                .inject(this)
    }

    override fun onDestroy() {
        subscriptions.unsubscribe()
        super.onDestroy()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_article_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = ArticleListAdapter(context, mutableListOf())

        val listView = view?.findViewById(R.id.fragment_article_list_list_view) as ListView
        listView.adapter = adapter
        listView.setOnItemClickListener {
            adapterView, view, i, l -> startWebBrowser(adapter.getItem(i))
        }

        fetchArticles()
    }

    private fun fetchArticles() {
        subscriptions.add(getArticleUseCase.getArticles(site, category)
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