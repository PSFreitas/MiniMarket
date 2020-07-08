package com.example.data.network

import com.google.gson.annotations.SerializedName

data class SizeNetwork(
    @SerializedName("available") val isAvailable: Boolean,
    @SerializedName("size") val size: String,
    @SerializedName("sku") val sku: String
)