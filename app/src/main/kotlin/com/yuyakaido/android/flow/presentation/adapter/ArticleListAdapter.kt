package com.yuyakaido.android.flow.presentation.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.domain.Article

/**
 * Created by yuyakaido on 6/25/16.
 */
class ArticleListAdapter(context: Context, val articles: List<Article>) : ArrayAdapter<Article>(context, 0, articles) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var view = convertView
        val holder: ViewHolder

        if (view == null) {
            view = View.inflate(context, R.layout.item_article, null)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }

        val item = getItem(position)

        holder.title.text = item.title()
        Glide.with(context).load(item.thumbnail()).into(holder.thumbnail)

        return view
    }

    override fun getCount(): Int {
        return articles.count()
    }

    override fun getItem(position: Int): Article {
        return articles[position]
    }

    class ViewHolder(view: View) {
        val title: TextView
        val thumbnail: ImageView

        init {
            title = view.findViewById(R.id.item_article_title) as TextView
            thumbnail = view.findViewById(R.id.item_article_thumbnail) as ImageView
        }
    }

}