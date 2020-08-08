package com.minimarket.data.network

import com.google.gson.annotations.SerializedName

/**
 * A class the represents the object obtained from Product request
 *
 * @property name of the product
 * @property style of the product
 * @property codeColor of the product
 * @property colorSlug of the product
 * @property color of the product
 * @property isOnSale if the product is on sale
 * @property regularPrice of the product
 * @property actualPrice of the product
 * @property discountPercentage of the product
 * @property installments of the product
 * @property image of the product
 * @property existentSizes of the product
 * */
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