package com.minimarket

import com.minimarket.data.network.mapper.Mapper
import com.minimarket.domain.entities.ProductEntity
import com.minimarket.entity.ProductViewEntity
import java.math.BigDecimal

class ProductViewEntityMapper(
    private val sizeViewEntityMapper: SizeViewEntityMapper
) : Mapper<List<ProductEntity>, List<ProductViewEntity>> {

    override fun map(input: List<ProductEntity>): List<ProductViewEntity> {
        val productViewEntities = mutableListOf<ProductViewEntity>()

        for (product in input) {
            productViewEntities.add(
                ProductViewEntity(
                    name = product.name,
                    color = product.color,
                    image = product.image,
                    isOnSale = product.isOnSale,
                    actualPrice = formatPrice(product.actualPrice),
                    regularPrice = formatPrice(product.regularPrice),
                    style = product.style,
                    existentSizes = sizeViewEntityMapper.map(product.existentSizes)
                )
            )
        }

        return productViewEntities
    }


    private fun formatPrice(price: BigDecimal): String {
        return "R$ ${price.toString()}"
    }

    override fun reverseMap(input: List<ProductViewEntity>): List<ProductEntity> {
        TODO("Not yet implemented")
    }
}