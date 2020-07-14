package com.minimarket.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.minimarket.R
import com.squareup.picasso.Picasso
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class BindingAdapters {
    companion object {
        @JvmStatic
        @BindingAdapter("formatPrice")
        fun formatPrice(textView: TextView, price: BigDecimal) {
            textView.text = NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(price)

        }

        @JvmStatic
        @BindingAdapter("setImage")
        fun setImage(imageView: ImageView, path: String) {
            if (path.isNotBlank() && path.isNotEmpty())
                Picasso
                    .get()
                    .load(path)
                    .placeholder(android.R.color.white)
                    .error(R.color.cardview_dark_background)
                    .into(imageView)
        }
    }
}