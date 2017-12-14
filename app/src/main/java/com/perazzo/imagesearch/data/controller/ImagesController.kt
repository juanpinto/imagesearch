package com.perazzo.imagesearch.data.controller

import com.perazzo.imagesearch.data.api.ImagesApi
import com.perazzo.imagesearch.data.local.preferences.PreferencesManager
import com.perazzo.imagesearch.data.models.Image
import com.perazzo.imagesearch.data.models.Photos
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.stream.Collectors

class ImagesController(private val imagesApi: ImagesApi, private val preferencesManager: PreferencesManager) {

    private lateinit var currentTag: String

    fun getImages(tag: String): Observable<Photos> {
        currentTag = tag
        return imagesApi.getImages(tag)
                .subscribeOn(Schedulers.io())
                .doOnNext {
                    result -> preferencesManager.saveLastSearch(tag, result)
                }
                .onErrorResumeNext (this::errorHandler)
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun filterImages(tag: String, images: List<Image>) : List<Image> {
        return images.filter({item -> item.title.contains(tag)})
    }

    private fun errorHandler(throwable: Throwable): Observable<Photos> {
        val data = preferencesManager.getLastSearch(currentTag)
        return Observable.just(data)
    }

}