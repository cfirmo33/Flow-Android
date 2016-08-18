package com.yuyakaido.android.flow.presentation.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.domain.entity.Article

/**
 * Created by yuyakaido on 6/25/16.
 */
class ArticleListAdapter(
        private val context: Context,
        private val articles: MutableList<Article>,
        private val listener: ItemClickListener<Article>) : RecyclerView.Adapter<ArticleListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(View.inflate(context, R.layout.item_article, null))
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val item = articles[position]

        holder?.let {
            holder.itemView.setOnClickListener { listener.onItemClick(item) }
            holder.title.text = item.title()
            Glide.with(context).load(item.thumbnail()).into(holder.thumbnail)
        }
    }

    fun clear() {
        articles.clear()
    }

    fun addAll(articles: List<Article>) {
        this.articles.addAll(articles)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val thumbnail: ImageView

        init {
            title = view.findViewById(R.id.item_article_title) as TextView
            thumbnail = view.findViewById(R.id.item_article_thumbnail) as ImageView
        }
    }

}