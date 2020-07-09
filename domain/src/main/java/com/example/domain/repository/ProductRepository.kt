package com.example.domain.repository

import com.example.domain.entities.ProductEntity

interface ProductRepository {
    fun getAllProducts(): List<ProductEntity>
}