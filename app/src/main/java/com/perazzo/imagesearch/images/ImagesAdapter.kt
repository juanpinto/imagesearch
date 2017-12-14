package com.perazzo.imagesearch.images

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.perazzo.imagesearch.data.models.Image

class ImagesAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var imagesList: List<Image> = ArrayList()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val imageItem: ImageItem = holder?.itemView as ImageItem
        imageItem.onBind(imagesList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view: View = ImageItem(parent!!.context)
        return object : RecyclerView.ViewHolder(view){}
    }

    override fun getItemId(position: Int): Long {
        return imagesList[position].id.toLong()
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }
}
