package com.yuyakaido.android.flow.presentation.fragment

import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.app.Flow
import com.yuyakaido.android.flow.di.module.ArticleListModule
import com.yuyakaido.android.flow.domain.entity.Article
import com.yuyakaido.android.flow.domain.entity.Category
import com.yuyakaido.android.flow.domain.entity.Site
import com.yuyakaido.android.flow.presentation.adapter.ArticleListAdapter
import com.yuyakaido.android.flow.presentation.adapter.ItemClickListener
import com.yuyakaido.android.flow.presentation.item.QiitaSubscription
import com.yuyakaido.android.flow.presentation.viewmodel.ArticleListViewModel
import com.yuyakaido.android.flow.util.ErrorHandler
import rx.subscriptions.CompositeSubscription
import java.io.Serializable
import javax.inject.Inject

/**
 * Created by yuyakaido on 6/20/16.
 */
class ArticleListFragment : BaseFragment(), ItemClickListener<Article> {

    class Component(
            val site: Site,
            val category: Category?,
            val qiitaSubscription: QiitaSubscription?) : Serializable

    private val component by lazy { arguments.getSerializable(ARGS_COMPONENT) as Component }
    private val subscriptions = CompositeSubscription()

    private lateinit var adapter: ArticleListAdapter

    @Inject
    lateinit var viewModel: ArticleListViewModel

    companion object {
        private val ARGS_COMPONENT = "ARGS_COMPONENT"

        fun newMenthasInstance(site: Site, category: Category): Fragment {
            return newInstance(Component(site, category, null))
        }

        fun newQiitaInstance(qiitaSubscription: QiitaSubscription): Fragment {
            return newInstance(Component(Site.Qiita, null, qiitaSubscription))
        }

        fun newInstance(component: Component): Fragment {
            val args = Bundle()
            args.putSerializable(ARGS_COMPONENT, component)
            val fragment = ArticleListFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Flow.getAppComponent().newArticleListComponent(ArticleListModule(component)).inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_article_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        subscriptions.add(viewModel.articles
                .subscribe({
                    addArticles(it)
                }, {
                    ErrorHandler.handle(it)
                }))
        subscriptions.add(viewModel.showProgressBar
                .subscribe({
                    val swipeRefreshLayout = view?.findViewById(R.id.fragment_article_list_swipe_refresh_layout) as SwipeRefreshLayout
                    swipeRefreshLayout.isRefreshing = it
                }, {
                    ErrorHandler.handle(it)
                }))
    }

    override fun onDestroyView() {
        subscriptions.unsubscribe()
        viewModel.onDestroy()
        super.onDestroyView()
    }

    override fun onItemClick(item: Article) {
        startWebBrowser(item)
    }

    fun initialize() {
        adapter = ArticleListAdapter(context, mutableListOf(), this)

        val swipeRefreshLayout = view?.findViewById(R.id.fragment_article_list_swipe_refresh_layout) as SwipeRefreshLayout
        swipeRefreshLayout.setOnRefreshListener {
            clearArticles()
            viewModel.refreshTrigger.onNext(null)
        }

        val layoutManager = LinearLayoutManager(context)
        val recyclerView = view?.findViewById(R.id.fragment_article_list_recycler_view) as RecyclerView
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        viewModel.registerPaginationTrigger(recyclerView, layoutManager)
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
        val intent = CustomTabsIntent.Builder().addDefaultShareMenuItem().build()
        intent.launchUrl(activity, Uri.parse(article.url()))
    }

}