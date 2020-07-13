package com.minimarket.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.network.repository.ProductRepositoryImplementation
import com.example.domain.ResultData
import kotlinx.coroutines.launch

class ProductViewModel(
    private val productRepository: ProductRepositoryImplementation
) : ViewModel() {

    fun getAllProducts() {

        viewModelScope.launch {
            val resultData = productRepository.getAllProducts()

            if (resultData is ResultData.Success) {
                var a = 0
            } else {
                var b = 0
            }
        }


    }
}