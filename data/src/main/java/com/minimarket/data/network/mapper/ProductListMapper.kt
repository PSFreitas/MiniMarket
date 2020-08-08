package com.minimarket.data.network.mapper

import com.minimarket.data.network.ProductNetwork
import com.minimarket.domain.entities.ProductEntity
import java.math.BigDecimal

/**
 * A mapper class used to convert a list of ProductNetwork to a list of ProductEntity
 *
 * */
class ProductListMapper(
    private val sizeListMapper: SizeListMapper
) : Mapper<List<ProductNetwork>, List<ProductEntity>> {
    override fun map(input: List<ProductNetwork>): List<ProductEntity> {
        val productsEntity = mutableListOf<ProductEntity>()

        for (productNetwork in input) {
            productsEntity.add(
                ProductEntity(
                    name = productNetwork.name,
                    style = productNetwork.style,
                    regularPrice = BigDecimal(formatPrice(productNetwork.regularPrice)),
                    actualPrice = BigDecimal(formatPrice(productNetwork.actualPrice)),
                    isOnSale = productNetwork.isOnSale,
                    image = productNetwork.image,
                    color = productNetwork.color,
                    existentSizes = sizeListMapper.map(productNetwork.existentSizes)
                )
            )
        }

        return productsEntity

    }

    private fun formatPrice(regularPrice: String): String {
        return regularPrice.replace(
            "R$", ""
        ).replace(",", ".").trim()
    }

    override fun reverseMap(input: List<ProductEntity>): List<ProductNetwork> {
        TODO("Not yet implemented")
    }
}