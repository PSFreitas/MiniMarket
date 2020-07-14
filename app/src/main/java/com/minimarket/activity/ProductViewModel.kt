package com.minimarket.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.network.repository.ProductRepositoryImplementation
import com.example.domain.ResultData
import com.example.domain.entities.ProductEntity
import kotlinx.coroutines.launch

class ProductViewModel(
    private val productRepository: ProductRepositoryImplementation
) : ViewModel() {

    private val _productList = MutableLiveData<List<ProductEntity>>()
    var productList: LiveData<List<ProductEntity>> = _productList

    fun getAllProducts() {

        viewModelScope.launch {
            val resultData = productRepository.getAllProducts()

            if (resultData is ResultData.Success) {
                _productList.value = resultData.data
            } else {
                //Figure out how to deal with error
            }
        }


    }
}