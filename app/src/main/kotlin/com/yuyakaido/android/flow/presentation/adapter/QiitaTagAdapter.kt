package com.yuyakaido.android.flow.presentation.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.domain.entity.QiitaTag

/**
 * Created by yuyakaido on 8/15/16.
 */
class QiitaTagAdapter(context: Context, val tags: List<QiitaTag>) : ArrayAdapter<QiitaTag>(context, 0, tags) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var view = convertView
        val holder: ViewHolder

        if (view == null) {
            view = View.inflate(context, R.layout.item_qiita_tag, null)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }

        val item = getItem(position)

        holder.name.text = item.name
        holder.subscribed.isChecked = item.subscribed
        holder.subscribed.tag = item

        return view
    }

    private class ViewHolder(view: View) {
        val name: TextView
        val subscribed: CheckBox

        init {
            name = view.findViewById(R.id.item_qiita_tag_name) as TextView
            subscribed = view.findViewById(R.id.item_qiita_tag_subscribed) as CheckBox
        }
    }

}