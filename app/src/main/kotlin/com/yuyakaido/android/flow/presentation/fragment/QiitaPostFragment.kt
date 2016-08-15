package com.yuyakaido.android.flow.presentation.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yuyakaido.android.flow.R

/**
 * Created by yuyakaido on 8/15/16.
 */
class QiitaPostFragment : BaseFragment() {

    companion object {

        fun newInstance(): Fragment {
            return QiitaPostFragment()
        }

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_qiita_post, container, false)
    }

}