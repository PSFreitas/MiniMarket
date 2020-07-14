package com.minimarket.activity

import androidx.lifecycle.ViewModel
import com.minimarket.entity.ProductViewEntity

class ProductDetailViewModel : ViewModel() {

    lateinit var productViewEntity: ProductViewEntity

    fun setProduct(productViewEntitySelected: ProductViewEntity) {
        productViewEntity = productViewEntitySelected
    }
}