package com.perazzo.imagesearch.utils.binding_adapters

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.perazzo.imagesearch.utils.transformations.RoundedCornersTransformation
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, imageUrl: String) {

    val transformation: Transformation = RoundedCornersTransformation()
    Picasso.with(imageView.context)
            .load(imageUrl)
            .transform(transformation)
            .into(imageView)
}