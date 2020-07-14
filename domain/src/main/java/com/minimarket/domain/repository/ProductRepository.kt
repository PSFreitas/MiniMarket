package com.minimarket.domain.repository

import com.minimarket.domain.ResultData
import com.minimarket.domain.entities.ProductEntity

interface ProductRepository {
    suspend fun getAllProducts(): ResultData<List<ProductEntity>>
}