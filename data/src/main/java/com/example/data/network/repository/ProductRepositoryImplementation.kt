package com.example.data.network.repository

import com.example.data.network.mapper.ProductListMapper
import com.example.data.network.mapper.SizeListMapper
import com.example.data.network.service.ProductService
import com.example.domain.ResultData
import com.example.domain.entities.ProductEntity
import com.example.domain.repository.ProductRepository

class ProductRepositoryImplementation(
    private val productApi: ProductService,
    private val productMapper: ProductListMapper = ProductListMapper(SizeListMapper())

) : ProductRepository {

    override suspend fun getAllProducts(): ResultData<List<ProductEntity>> {

        return when (val response = productApi.getAllProducts()) {
            is ResultData.Success -> ResultData.Success(productMapper.map(response.data.body()!!.products))
            is ResultData.Error -> ResultData.Error(Exception())
        }

    }

}