package com.yuyakaido.android.flow.presentation.binder

import android.databinding.BindingAdapter
import android.databinding.DataBindingComponent
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by yuyakaido on 2016/12/03.
 */
class CustomBinder : DataBindingComponent {

    override fun getCompanion() = CustomBinder.Companion

    companion object {
        @JvmStatic
        @BindingAdapter("app:imageUrl")
        fun imageUrl(imageView: ImageView, url: String?) {
            Glide.with(imageView.context).load(url).into(imageView)
        }
    }

}