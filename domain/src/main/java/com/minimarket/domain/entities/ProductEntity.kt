package com.minimarket.domain.entities

import java.math.BigDecimal

/**
 * A class that represents the Product
 *
 * @property name of the product
 * @property style of the product
 * @property color of the product
 * @property isOnSale if the product is on sale
 * @property regularPrice of the product
 * @property actualPrice of the product
 * @property image of the product
 * @property existentSizes of the product
 * */
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