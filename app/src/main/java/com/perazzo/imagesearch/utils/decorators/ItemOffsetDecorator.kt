package com.perazzo.imagesearch.utils.decorators

import android.content.Context
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.support.annotation.DimenRes
import android.view.View


class ItemOffsetDecorator: RecyclerView.ItemDecoration {

    private  var mItemOffset: Int

    constructor(itemOffset: Int):super(){
        mItemOffset = itemOffset
    }

    constructor(context: Context, @DimenRes itemOffsetId: Int): this(context.resources.getDimensionPixelSize(itemOffsetId))

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView,
                       state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset)
    }
}