package com.hubose.eniroapplication.common

import android.widget.ImageView

interface ImageLoader {
    fun load(url: String, imageView: ImageView, fadeEffect: Boolean = true)
}