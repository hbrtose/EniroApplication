package com.hubose.eniroapplication.common

import android.widget.ImageView
import com.squareup.picasso.Picasso

class PicassoImageLoader(private val picasso: Picasso) : ImageLoader {

    override fun load(url: String, imageView: ImageView, fadeEffect: Boolean) {
        if (fadeEffect)
            picasso.load(url).into(imageView)
        else
            picasso.load(url).noFade().into(imageView)
    }
}