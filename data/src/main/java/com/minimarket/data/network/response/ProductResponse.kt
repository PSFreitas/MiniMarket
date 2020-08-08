package com.minimarket.data.network.response

import com.minimarket.data.network.ProductNetwork
import com.google.gson.annotations.SerializedName

/**
 * A class that represents the ProductResponse obtained from request.
 * */
class ProductResponse {

    @SerializedName("products")
    val products: List<ProductNetwork> = listOf()
}
