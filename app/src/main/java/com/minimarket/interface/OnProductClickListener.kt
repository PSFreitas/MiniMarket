package com.minimarket.`interface`

import com.minimarket.domain.entities.ProductEntity

interface OnProductClickListener {
    fun onProductClick(product: ProductEntity)
}