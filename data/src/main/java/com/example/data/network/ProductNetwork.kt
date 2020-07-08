package com.example.data.network

import com.google.gson.annotations.SerializedName

data class ProductNetwork(
    @SerializedName("name") val name: String,
    @SerializedName("style") val style: String,
    @SerializedName("code_color") val codeColor: String,
    @SerializedName("color_slug") val colorSlug: String,
    @SerializedName("color") val color: String,
    @SerializedName("on_sale") val isOnSale: Boolean,
    @SerializedName("regular_price") val regularPrice: String,
    @SerializedName("actual_price") val actualPrice: String,
    @SerializedName("discount_percentage") val discountPercentage: String,
    @SerializedName("installments") val installments: String,
    @SerializedName("image") val image: String,
    @SerializedName("sizes") val existentSizes: ArrayList<SizeNetwork>
)