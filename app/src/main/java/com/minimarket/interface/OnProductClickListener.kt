package com.minimarket.`interface`

import android.widget.ImageView
import com.minimarket.entity.ProductViewEntity

interface OnProductClickListener {
    fun onProductClick(product: ProductViewEntity, imageView: ImageView)
}