package com.cornerjob.marvelheroes.presentation.util

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView


class SquareImageView(context: Context, attributes: AttributeSet) : AppCompatImageView(context, attributes) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = measuredWidth
        setMeasuredDimension(width, width)
    }
}