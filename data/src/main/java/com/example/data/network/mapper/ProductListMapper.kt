package com.example.data.network.mapper

import com.example.data.network.ProductNetwork
import com.example.domain.entities.ProductEntity
import java.math.BigDecimal

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
                    regularPrice = BigDecimal(productNetwork.regularPrice),
                    actualPrice = BigDecimal(productNetwork.actualPrice),
                    isOnSale = productNetwork.isOnSale,
                    image = productNetwork.image,
                    color = productNetwork.color,
                    existentSizes = sizeListMapper.map(productNetwork.existentSizes)
                )
            )
        }

        return productsEntity

    }

    override fun reverseMap(input: List<ProductEntity>): List<ProductNetwork> {
        TODO("Not yet implemented")
    }
}