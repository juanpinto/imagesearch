package com.perazzo.imagesearch.data.models

import com.google.gson.annotations.SerializedName

class Photos(@SerializedName("photos") val response: ImagesResponse)