package com.example.data.network.repository

import com.example.data.network.ProductNetwork
import com.example.data.network.mapper.Mapper
import com.example.data.network.service.ProductService
import com.example.domain.entities.ProductEntity
import com.example.domain.repository.ProductRepository

class ProductRepositoryImplementation(
    val productApi: ProductService,
    val productMapper: Mapper<ProductNetwork, ProductEntity>

) : ProductRepository {

    override fun getAllProducts(): List<ProductEntity> {
        val response = productApi.getAllProducts()
        val productEntities = mutableListOf<ProductEntity>()

        if (response.isSuccessful) {
            val productsNetwork = response.body()?.products

            if (productsNetwork != null) {
                for (product in productsNetwork) {
                    productEntities.add(
                        productMapper.map(product)
                    )
                }
            }
        }
        
        return productEntities
    }

}