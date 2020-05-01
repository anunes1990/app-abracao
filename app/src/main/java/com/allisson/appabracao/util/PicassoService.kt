package com.allisson.appabracao.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.allisson.appabracao.R
import com.squareup.picasso.Picasso

class PicassoService {
    companion object {
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun loadImage(view: ImageView, url: String) {
            if (url.isNotEmpty()) {
                Picasso.get().load(url).error(R.drawable.ic_launcher_foreground)
                    .placeholder(R.drawable.ic_launcher_foreground).into(view)
            }

        }
    }
}