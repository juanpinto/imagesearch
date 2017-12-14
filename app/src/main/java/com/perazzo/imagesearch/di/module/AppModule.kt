package com.perazzo.imagesearch.di.module

import android.content.Context
import com.perazzo.imagesearch.ImageSearchApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val imageSearchApp: ImageSearchApplication) {

    @Provides
    @Singleton
    fun context(): Context {
        return imageSearchApp
    }
}