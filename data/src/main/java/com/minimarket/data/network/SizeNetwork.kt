package com.minimarket.data.network

import com.google.gson.annotations.SerializedName

/**
 * A class the represents the object that composes the ProductNetwork object.
 *
 * @property isAvailable if the size is available
 * @property size of the product
 * @property sku of the product
 * */
data class SizeNetwork(
    @SerializedName("available") val isAvailable: Boolean,
    @SerializedName("size") val size: String,
    @SerializedName("sku") val sku: String
)