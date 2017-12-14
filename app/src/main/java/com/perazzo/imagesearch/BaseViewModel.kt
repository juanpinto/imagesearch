package com.perazzo.imagesearch

import android.databinding.BaseObservable
import android.databinding.ObservableBoolean
import com.perazzo.imagesearch.di.component.DaggerViewModelComponent
import com.perazzo.imagesearch.di.component.ViewModelComponent

open class BaseViewModel : BaseObservable() {

    val loaderVisibility: ObservableBoolean = ObservableBoolean()

    init {
        loaderVisibility.set(false)
    }

     fun getComponent(): ViewModelComponent {
        return DaggerViewModelComponent.builder()
                .appComponent(ImageSearchApplication.get().appComponent)
                .build()
    }
}