package com.perazzo.imagesearch.data.controller

import com.perazzo.imagesearch.data.api.ImagesApi
import com.perazzo.imagesearch.data.models.Image
import com.perazzo.imagesearch.data.models.Photos
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.stream.Collectors

class ImagesController(private val imagesApi: ImagesApi) {

    fun getImages(tag: String): Observable<Photos> {
        return imagesApi.getImages(tag)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun filterImages(tag: String, images: List<Image>) : List<Image> {
        return images.stream().filter({item -> item.title.contains(tag)}).collect(Collectors.toList())
    }

}