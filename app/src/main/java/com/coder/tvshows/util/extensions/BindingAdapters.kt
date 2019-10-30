package com.coder.tvshows.util.extensions

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.coder.tvshows.R

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(url: String?) {

    Glide.with(context).load(url)
        .apply(RequestOptions.placeholderOf(R.color.grey))
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}