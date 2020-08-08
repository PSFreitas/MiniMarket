package com.minimarket.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.minimarket.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class BindingAdapters {
    companion object {
        @JvmStatic
        @BindingAdapter("formatPrice")
        fun formatPrice(textView: TextView, price: String) {
            val bigDecimal = BigDecimal(price)
            val formattedPrice = NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(bigDecimal)
            textView.text = formattedPrice.replace("R$","R$ ")

        }

        @JvmStatic
        @BindingAdapter("setseImage")
        fun setImage(imageView: ImageView, path: String) {
            if (path.isNotBlank() && path.isNotEmpty())
                Picasso
                    .get()
                    .load(path)
                    .placeholder(android.R.color.white)
                    .error(R.color.cardview_dark_background)
                    .into(imageView, object : Callback {
                        override fun onSuccess() {
                            TODO("Not yet implemented")
                        }

                        override fun onError(e: Exception?) {
                            TODO("Not yet implemented")
                        }

                    })
        }
    }
}