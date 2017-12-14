package com.perazzo.imagesearch.di.component

import android.content.Context
import com.perazzo.imagesearch.data.controller.ImagesController
import com.perazzo.imagesearch.di.module.ApiModule
import com.perazzo.imagesearch.di.module.AppModule
import com.perazzo.imagesearch.di.module.ControllerModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, ApiModule::class, ControllerModule::class))
interface AppComponent {


    fun context(): Context


    /**
     *  Apis
     **/

    fun retrofit(): Retrofit

    /**
     *  Controllers
     **/

    fun imagesController(): ImagesController

}