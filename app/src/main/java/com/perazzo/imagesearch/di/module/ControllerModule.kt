package com.perazzo.imagesearch.di.module

import com.perazzo.imagesearch.data.api.ImagesApi
import com.perazzo.imagesearch.data.controller.ImagesController
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ControllerModule {

    @Provides
    @Singleton
    fun imagesController(imagesApi: ImagesApi) : ImagesController {
        return ImagesController(imagesApi)
    }
}