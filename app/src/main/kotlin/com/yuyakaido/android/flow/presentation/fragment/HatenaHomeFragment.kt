package com.yuyakaido.android.flow.presentation.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.yuyakaido.android.flow.R
import com.yuyakaido.android.flow.presentation.item.HatenaItem

/**
 * Created by yuyakaido on 8/16/16.
 */
class HatenaHomeFragment : BaseFragment(), AdapterView.OnItemSelectedListener {

    companion object {

        fun newInstance(): Fragment {
            return HatenaHomeFragment()
        }

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_hatena_home, container, false)
    }

    override fun onDestroyView() {
        val spinner = activity.findViewById(R.id.spinner) as Spinner?
        spinner?.let {
            spinner.visibility = View.GONE
        }
        super.onDestroyView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initializeSpinner()
        replaceFragment(HatenaItem.Hot)
    }

    override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
        replaceFragment(HatenaItem.fromPosition(position))
    }

    override fun onNothingSelected(adapterView: AdapterView<*>?) {}

    fun initializeSpinner() {
        val spinner = activity.findViewById(R.id.spinner) as Spinner?
        spinner?.let {
            spinner.visibility = View.VISIBLE
            spinner.onItemSelectedListener = this
            spinner.adapter = ArrayAdapter.createFromResource(
                    context,
                    R.array.hatena_tabs,
                    android.R.layout.simple_spinner_dropdown_item)
        }
    }

    fun replaceFragment(item: HatenaItem) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_hatena_home_fragment_container, item.fragment())
        transaction.commit()
    }

}