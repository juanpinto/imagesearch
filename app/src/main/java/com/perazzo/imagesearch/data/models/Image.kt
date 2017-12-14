package com.perazzo.imagesearch.data.models

import com.google.gson.annotations.SerializedName

data class Image(@SerializedName("id") val id: String,
                 @SerializedName("farm") val farm:String,
                 @SerializedName("owner") val owner: String,
                 @SerializedName("secret") val secret: String,
                 @SerializedName("title") val title: String,
                 @SerializedName("server") val server: String)