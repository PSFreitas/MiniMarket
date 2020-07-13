package com.example.data.network.repository

import com.example.data.network.mapper.ProductMapper
import com.example.data.network.mapper.SizeMapper
import com.example.data.network.service.ProductService
import com.example.domain.entities.ProductEntity
import com.example.domain.repository.ProductRepository

class ProductRepositoryImplementation(
    val productApi: ProductService,
    val productMapper: ProductMapper = ProductMapper(SizeMapper())

) : ProductRepository {

    override fun getAllProducts(): List<ProductEntity> {
        TODO()
    }

}