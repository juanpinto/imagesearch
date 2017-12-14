package com.perazzo.imagesearch.data.api

import com.perazzo.imagesearch.data.models.Photos
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ImagesApi {

    @GET("rest/")
    fun getImages(@Query("tags") tag : String): Observable<Photos>

}