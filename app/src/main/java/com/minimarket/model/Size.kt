package com.minimarket.model

import com.google.gson.annotations.SerializedName

data class Size(
    @SerializedName("available") val isAvailable: Boolean = false,
    @SerializedName("size") val size: String = "",
    @SerializedName("sku") val sku: String = ""
)