package com.minimarket.model

data class Product(
    val name: String = "",
    val style: String = "",
    val codeColor: String = "",
    val colorSlug: String = "",
    val color: String = "",
    val isOnSale: Boolean = false,
    val regularPrice: String = "",
    val actualPrice: String = "",
    val discountPercentage: String = "",
    val installments: String = "",
    val image: String = "",
    val existentSizes: ArrayList<Size> = ArrayList()
)