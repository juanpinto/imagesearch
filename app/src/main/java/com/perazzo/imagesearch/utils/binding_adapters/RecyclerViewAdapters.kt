package com.perazzo.imagesearch.utils.binding_adapters

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.perazzo.imagesearch.data.models.Image
import com.perazzo.imagesearch.images.ImagesAdapter


@BindingAdapter("updateData")
fun updateData(recyclerView: RecyclerView, images: List<Image>) {
    val imagesAdapter = recyclerView.adapter as ImagesAdapter?
    imagesAdapter?.imagesList = images
    imagesAdapter?.notifyDataSetChanged()

}