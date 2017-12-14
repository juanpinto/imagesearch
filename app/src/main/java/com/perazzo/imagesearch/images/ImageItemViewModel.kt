package com.perazzo.imagesearch.images

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.widget.ImageView
import com.perazzo.imagesearch.BaseViewModel
import com.perazzo.imagesearch.R
import com.perazzo.imagesearch.data.models.Image
import com.perazzo.imagesearch.utils.ImageUtils
import javax.inject.Inject

class ImageItemViewModel(val image: Image): BaseViewModel() {


    @Inject
    lateinit var context: Context

    var url: String

    init {
        getComponent().inject(this)
        url = context.getString(R.string.image_url, image.farm, image.server, image.id, image.secret)
    }

    fun shareImage(imageView: ImageView) {
        val bitmap = (imageView.drawable as BitmapDrawable).bitmap
        ImageUtils.prepareShareIntent(context, bitmap)
    }
}