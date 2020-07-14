package com.minimarket.`interface`

import com.minimarket.entity.ProductViewEntity

interface OnProductClickListener {
    fun onProductClick(product: ProductViewEntity)
}