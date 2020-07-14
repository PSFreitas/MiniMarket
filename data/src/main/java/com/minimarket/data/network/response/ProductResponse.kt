package com.minimarket.data.network.response

import com.minimarket.data.network.ProductNetwork
import com.google.gson.annotations.SerializedName


class ProductResponse {

    @SerializedName("products")
    val products: List<ProductNetwork> = listOf()
}
