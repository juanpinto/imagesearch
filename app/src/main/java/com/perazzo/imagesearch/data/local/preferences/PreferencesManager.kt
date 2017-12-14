package com.perazzo.imagesearch.data.local.preferences

import android.content.Context
import com.google.gson.Gson
import com.perazzo.imagesearch.data.models.Photos


class PreferencesManager(val context: Context) {

    fun saveLastSearch(tag: String, images: Photos) {
        val json = Gson().toJson(images, Photos::class.java)
        val sharedPreferences = context.getSharedPreferences("image_search", 0)
        val editor = sharedPreferences.edit()
        editor.putString("last_search_" + tag, json)
        editor.apply()
    }

    fun getLastSearch(tag: String):Photos {
        val sharedPreferences = context.getSharedPreferences("image_search", 0)
        val json = sharedPreferences.getString("last_search_" + tag, "{}")
        return Gson().fromJson(json, Photos::class.java)

    }
}