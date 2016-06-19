package com.yuyakaido.android.flow

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by yuyakaido on 6/20/16.
 */
class ArticleFragment : Fragment() {

    companion object {
        val ARGS_CATEGORY = "ARGS_CATEGORY"

        fun newInstance(category: Category) : Fragment {
            val args = Bundle()
            args.putSerializable(ARGS_CATEGORY, category)
            val fragment = ArticleFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_article, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val category = arguments.getSerializable(ARGS_CATEGORY) as Category
        val name = view?.findViewById(R.id.fragment_article_category_name) as TextView
        name.text = category.name
    }

}