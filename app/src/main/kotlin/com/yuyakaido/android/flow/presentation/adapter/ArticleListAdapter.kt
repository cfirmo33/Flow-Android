package com.yuyakaido.android.flow.presentation.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.yuyakaido.android.flow.databinding.ItemArticleBinding
import com.yuyakaido.android.flow.domain.entity.Article

/**
 * Created by yuyakaido on 6/25/16.
 */
class ArticleListAdapter(
        private val context: Context,
        private val articles: MutableList<Article>,
        private val listener: ItemClickListener<Article>) : RecyclerView.Adapter<ArticleListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(ItemArticleBinding.inflate(LayoutInflater.from(context)))
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]
        holder.binding.article = articles[position]
        holder.itemView.setOnClickListener { listener.onItemClick(article) }
    }

    fun clear() {
        articles.clear()
    }

    fun addAll(articles: List<Article>) {
        this.articles.addAll(articles)
    }

    class ViewHolder(val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root)

}