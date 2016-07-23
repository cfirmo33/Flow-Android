package com.yuyakaido.android.flow.presentation.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yuyakaido.android.flow.R

/**
 * Created by yuyakaido on 7/23/16.
 */
class QiitaFragment : BaseFragment() {

    companion object {

        fun newInstance() : Fragment {
            return QiitaFragment()
        }

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_qiita, container, false)
    }

}