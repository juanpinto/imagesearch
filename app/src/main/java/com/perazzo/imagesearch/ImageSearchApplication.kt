package com.perazzo.imagesearch

import android.app.Application
import com.perazzo.imagesearch.di.component.AppComponent
import com.perazzo.imagesearch.di.component.DaggerAppComponent
import com.perazzo.imagesearch.di.module.AppModule

class ImageSearchApplication: Application() {

    lateinit var appComponent: AppComponent

    companion object {
        lateinit var instance: ImageSearchApplication

        fun get(): ImageSearchApplication {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        setDaggerComponent()
    }

    private fun setDaggerComponent() {
        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }
}