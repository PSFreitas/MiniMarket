package com.example.domain.entities

import java.math.BigDecimal

class ProductEntity(
    val name: String,
    val style: String,
    val color: String,
    val isOnSale: Boolean,
    val regularPrice: BigDecimal,
    val actualPrice: BigDecimal,
    val image: String,
    val existentSizes: List<SizeEntity>
) {
}