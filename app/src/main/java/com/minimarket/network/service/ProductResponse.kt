package com.minimarket.network.service

import com.google.gson.annotations.SerializedName
import com.minimarket.model.Product

class ProductResponse {

    @SerializedName("products")
    val products: ArrayList<Product> = ArrayList()
}
