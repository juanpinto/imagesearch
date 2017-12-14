package com.perazzo.imagesearch.di.module

import com.perazzo.imagesearch.data.api.ImagesApi
import com.perazzo.imagesearch.data.controller.ImagesController
import com.perazzo.imagesearch.data.local.preferences.PreferencesManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ControllerModule {

    @Provides
    @Singleton
    fun imagesController(imagesApi: ImagesApi, preferencesManager: PreferencesManager) : ImagesController {
        return ImagesController(imagesApi, preferencesManager)
    }
}