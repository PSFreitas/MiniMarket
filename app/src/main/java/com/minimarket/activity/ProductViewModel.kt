package com.minimarket.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minimarket.data.network.repository.ProductRepositoryImplementation
import com.minimarket.domain.ResultData
import com.minimarket.domain.entities.ProductEntity
import com.minimarket.valuableobject.Resource
import kotlinx.coroutines.launch

class ProductViewModel(
    private val productRepository: ProductRepositoryImplementation
) : ViewModel() {

    private val _productList = MutableLiveData<Resource<List<ProductEntity>>>()
    var productList: LiveData<Resource<List<ProductEntity>>> = _productList

    fun getAllProducts() {

        _productList.value = Resource.loading()

        viewModelScope.launch {
            val resultData = productRepository.getAllProducts()

            if (resultData is ResultData.Success) {
                _productList.value = Resource.success(resultData.data)
            } else {
                _productList.value = Resource.error(Exception())
            }
        }


    }
}