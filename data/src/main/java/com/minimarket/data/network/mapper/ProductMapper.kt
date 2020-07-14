package com.minimarket.data.network.mapper

import com.minimarket.data.network.ProductNetwork
import com.minimarket.domain.entities.ProductEntity
import java.math.BigDecimal

class ProductMapper(
    val sizeMapper: SizeListMapper
) : Mapper<ProductNetwork, ProductEntity> {

    override fun map(input: ProductNetwork): ProductEntity {
        return ProductEntity(
            name = input.name,
            actualPrice = BigDecimal(input.actualPrice),
            regularPrice = BigDecimal(input.regularPrice),
            color = input.color,
            image = input.image,
            isOnSale = input.isOnSale,
            style = input.style,
            existentSizes = sizeMapper.map(input.existentSizes)
        )
    }

    override fun reverseMap(input: ProductEntity): ProductNetwork {
        TODO("Not yet implemented")
    }
}