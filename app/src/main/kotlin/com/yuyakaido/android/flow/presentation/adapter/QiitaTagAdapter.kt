package com.yuyakaido.android.flow.presentation.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.domain.entity.QiitaTag

/**
 * Created by yuyakaido on 8/15/16.
 */
class QiitaTagAdapter(
        private val context: Context,
        private val tags: MutableList<QiitaTag>,
        private val listener: ItemClickListener<QiitaTag>) : RecyclerView.Adapter<QiitaTagAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(View.inflate(context, R.layout.item_qiita_tag, null))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val item = tags[position]

        holder?.let {
            holder.name.text = item.name
            holder.subscribed.isChecked = item.subscribed
            holder.subscribed.tag = item

            holder.itemView.setOnClickListener {
                holder.subscribed.isChecked = !holder.subscribed.isChecked
                listener.onItemClick(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return tags.size
    }

    fun addAll(tags: List<QiitaTag>) {
        this.tags.addAll(tags)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val subscribed: CheckBox

        init {
            name = view.findViewById(R.id.item_qiita_tag_name) as TextView
            subscribed = view.findViewById(R.id.item_qiita_tag_subscribed) as CheckBox
        }
    }

}