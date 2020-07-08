package com.example.data.network.response

import com.example.data.network.ProductNetwork
import com.google.gson.annotations.SerializedName


class ProductResponse {

    @SerializedName("products")
    val products: List<ProductNetwork> = listOf()
}
