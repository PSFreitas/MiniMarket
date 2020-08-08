package com.minimarket.domain.repository

import com.minimarket.domain.ResultData
import com.minimarket.domain.entities.ProductEntity

/**
 * A interface that contains the methods that will be implemented on Product repository
 *
 */
interface ProductRepository {

    suspend fun getAllProducts(): ResultData<List<ProductEntity>>
}