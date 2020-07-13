package com.example.domain.repository

import com.example.domain.ResultData
import com.example.domain.entities.ProductEntity

interface ProductRepository {
    suspend fun getAllProducts(): ResultData<List<ProductEntity>>
}