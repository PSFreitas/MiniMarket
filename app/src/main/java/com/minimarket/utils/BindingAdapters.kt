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
        fun formatPrice(textView: TextView, price: BigDecimal) {
            textView.text = NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(price)

        }
    }
}