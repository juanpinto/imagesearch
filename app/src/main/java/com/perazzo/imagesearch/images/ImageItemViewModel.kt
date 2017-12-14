package com.perazzo.imagesearch.images

import android.content.Context
import com.perazzo.imagesearch.BaseViewModel
import com.perazzo.imagesearch.R
import com.perazzo.imagesearch.data.models.Image
import javax.inject.Inject

class ImageItemViewModel(val image: Image): BaseViewModel() {


    @Inject
    lateinit var context: Context

    var url: String

    init {
        getComponent().inject(this)
        url = context.getString(R.string.image_url, image.farm, image.server, image.id, image.secret)
    }
}