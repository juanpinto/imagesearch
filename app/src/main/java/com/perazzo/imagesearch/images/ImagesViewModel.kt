package com.perazzo.imagesearch.images

import android.databinding.Bindable
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.text.TextWatcher
import com.perazzo.imagesearch.BaseViewModel
import com.perazzo.imagesearch.data.controller.ImagesController
import com.perazzo.imagesearch.data.models.Image
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import android.text.Editable
import android.util.Log


class ImagesViewModel : BaseViewModel() {

    @Inject
    lateinit var imagesController: ImagesController

    var images: ObservableList<Image> = ObservableArrayList()

    var initialValues: List<Image> = ArrayList()

    lateinit var currentTag: String

    init {
        getComponent().inject(this)
    }

    fun requestImages() {
        loaderVisibility.set(true)
        imagesController.getImages(currentTag).subscribe({ result -> onImagesReceived(result.response.images) }, { error -> onError(error) })
    }

    @Bindable
    fun getTextWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                currentTag = s.toString()
                onImagesFiltered(imagesController.filterImages(currentTag, initialValues))
            }

            override fun afterTextChanged(s: Editable) {
            }
        }
    }

    private fun onImagesFiltered(images: List<Image>) {
        this.images.clear()
        this.images.addAll(images)
    }

    private fun onImagesReceived(images: List<Image>) {
        loaderVisibility.set(false)
        initialValues = images
        this.images.clear()
        this.images.addAll(images)
    }

    private fun onError(error: Throwable) {
        loaderVisibility.set(false)
    }
}