package com.perazzo.imagesearch.images

import android.content.Context
import android.databinding.DataBindingUtil
import android.widget.LinearLayout
import com.perazzo.imagesearch.databinding.ItemImageBinding
import android.view.LayoutInflater
import com.perazzo.imagesearch.R
import com.perazzo.imagesearch.data.models.Image


class ImageItem(context: Context): LinearLayout(context) {

    private val itemImageBinding: ItemImageBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.item_image, this, true)

    fun onBind(image: Image) {
        itemImageBinding.viewModel = ImageItemViewModel(image)
    }
}