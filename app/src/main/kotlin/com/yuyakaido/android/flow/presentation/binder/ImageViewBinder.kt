package com.yuyakaido.android.flow.presentation.binder

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by yuyakaido on 2016/12/03.
 */
@BindingAdapter("android:imageUrl")
fun ImageView.imageUrl(url: String?) {
    Glide.with(context).load(url).into(this)
}