package com.perazzo.imagesearch.utils

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Environment.DIRECTORY_PICTURES
import android.support.v4.content.ContextCompat
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException




class ImageUtils {


    companion object {

        fun prepareShareIntent(context: Context, bmp: Bitmap) {
            val bmpUri = ImageUtils.getLocalBitmapUri(context, bmp)
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.putExtra(Intent.EXTRA_STREAM, bmpUri)
            shareIntent.type = "image/*"
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            ContextCompat.startActivity(context, Intent.createChooser(shareIntent, "Share Opportunity"), null)

        }

        private fun getLocalBitmapUri(context: Context, bmp: Bitmap): Uri? {
            var bmpUri: Uri? = null
            val file = File(context.getExternalFilesDir(DIRECTORY_PICTURES), "share_image_" + System.currentTimeMillis() + ".png")
            var out: FileOutputStream?
            try {
                out = FileOutputStream(file)
                bmp.compress(Bitmap.CompressFormat.PNG, 90, out)
                try {
                    out.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                bmpUri = Uri.fromFile(file)
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            }

            return bmpUri
        }
    }
}