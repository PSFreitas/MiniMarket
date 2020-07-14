package com.minimarket.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.minimarket.data.network.repository.ProductRepositoryImplementation

class ProductViewModelFactory(
    private val productRepository: ProductRepositoryImplementation
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductViewModel(productRepository) as T
    }

}
