package com.perazzo.imagesearch.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.perazzo.imagesearch.data.api.ImagesApi
import dagger.Module
import dagger.Provides
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.logging.HttpLoggingInterceptor



@Module
class ApiModule {


    private val TIME_OUT: Long = 20

    @Provides
    @Singleton
    fun getImagesApi(retrofit: Retrofit): ImagesApi {
        return retrofit.create(ImagesApi::class.java)
    }

    @Provides
    @Singleton
    fun retrofit(gson: Gson): Retrofit {

        val okHttpClient: OkHttpClient.Builder = getHttpClientBuilder()
        return getRetrofitBuilder(okHttpClient.build(), "https://api.flickr.com/services/", gson).build()
    }

    @Provides
    @Singleton
    fun gson(): Gson {
        return GsonBuilder().create()
    }

    private fun getRetrofitBuilder(okHtppClient: OkHttpClient, url: String, gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
                .client(okHtppClient)
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))

    }

    private fun getHttpClientBuilder(): OkHttpClient.Builder {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(getClientInterceptor())

    }

    private fun getClientInterceptor(): Interceptor {
        return Interceptor { chain ->
            val initialRequest: Request = chain!!.request()
            val initialUrl: HttpUrl = initialRequest.url()
            val finalUrl: HttpUrl = initialUrl.newBuilder()
                    .addQueryParameter("format", "json")
                    .addQueryParameter("nojsoncallback", "1")
                    .addQueryParameter("api_key", "6a8e0794c29c9c6641e639af0f2e0754")
                    .addQueryParameter("method", "flickr.photos.search")
                    .build()
            val requestBuilder: Request.Builder = initialRequest.newBuilder().url(finalUrl)
            chain.proceed(requestBuilder.build())
        }
    }


}