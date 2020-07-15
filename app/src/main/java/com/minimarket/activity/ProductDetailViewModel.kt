package com.minimarket.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.minimarket.entity.ProductViewEntity

class ProductDetailViewModel : ViewModel() {

    var productViewEntity = MutableLiveData<ProductViewEntity>()

    fun setProduct(productViewEntitySelected: ProductViewEntity) {
        productViewEntity.value = productViewEntitySelected
    }
}