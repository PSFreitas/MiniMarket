package com.minimarket.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class BindingAdapters {
    companion object {
        @JvmStatic
        @BindingAdapter("formatPrice")
        fun formatPrice(textView: TextView, price: String) {
            val bigDecimal = BigDecimal(price)
            val formattedPrice =
                NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(bigDecimal)
            textView.text = formattedPrice.replace("R$", "R$ ")

        }


        @JvmStatic
        @BindingAdapter("formatCartItemCount")
        fun formatCartItemCount(textView: TextView, itemCount: Int) {
            if (itemCount > 99) {
                textView.text = "99+"
            } else {
                textView.text = itemCount.toString()
            }
        }

    }
}