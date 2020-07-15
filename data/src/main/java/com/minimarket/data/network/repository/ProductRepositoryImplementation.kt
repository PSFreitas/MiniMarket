package com.minimarket.data.network.repository

import com.minimarket.data.network.mapper.ProductListMapper
import com.minimarket.data.network.mapper.SizeListMapper
import com.minimarket.data.network.service.ProductService
import com.minimarket.domain.ResultData
import com.minimarket.domain.entities.ProductEntity
import com.minimarket.domain.repository.ProductRepository

class ProductRepositoryImplementation(
    private val productApi: ProductService = ProductService.create(),
    private val productListMapper: ProductListMapper = ProductListMapper(SizeListMapper())
) : ProductRepository {

    override suspend fun getAllProducts(): ResultData<List<ProductEntity>> {
        val response = productApi.getAllProducts()

        return if (response.isSuccessful) {
            ResultData.Success(productListMapper.map(response.body()!!.products))
        } else {
            ResultData.Error(Exception())
        }

    }

}