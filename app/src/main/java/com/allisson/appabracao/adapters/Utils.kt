package com.allisson.appabracao.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.allisson.appabracao.R
import com.squareup.picasso.Picasso

class Utils {
    companion object {
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun loadImage(view: ImageView, url: String) {
            Picasso.get().load(url).error(R.drawable.ic_launcher_foreground).placeholder(R.drawable.ic_launcher_foreground).into(view)
        }
    }
}