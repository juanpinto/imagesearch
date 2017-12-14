package com.perazzo.imagesearch.data.models

import com.google.gson.annotations.SerializedName

data class ImagesResponse(@SerializedName("page") val page: Int, @SerializedName("perpage") val perpage: Int, @SerializedName("photo") val images: List<Image>)