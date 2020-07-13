package com.example.data.network.mapper

import com.example.data.network.ProductNetwork
import com.example.domain.entities.ProductEntity
import java.math.BigDecimal

class ProductMapper(
    val sizeMapper: SizeMapper
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