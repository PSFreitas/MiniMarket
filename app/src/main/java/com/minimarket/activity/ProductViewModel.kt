package com.minimarket.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minimarket.ProductViewEntityMapper
import com.minimarket.SizeViewEntityMapper
import com.minimarket.data.network.repository.ProductRepositoryImplementation
import com.minimarket.domain.ResultData
import com.minimarket.entity.ProductViewEntity
import com.minimarket.valuableobject.Resource
import kotlinx.coroutines.launch

class ProductViewModel(
    private val productRepository: ProductRepositoryImplementation
) : ViewModel() {

    private val productViewEntityMapper = ProductViewEntityMapper(SizeViewEntityMapper())

    private val _productList = MutableLiveData<Resource<List<ProductViewEntity>>>()
    var productList: LiveData<Resource<List<ProductViewEntity>>> = _productList

    fun getAllProducts() {

        _productList.value = Resource.loading()

        viewModelScope.launch {
            val resultData = productRepository.getAllProducts()

            if (resultData is ResultData.Success) {
                val productViewEntityList = productViewEntityMapper.map(
                    resultData.data
                )
                _productList.value = Resource.success(productViewEntityList)
            } else {
                _productList.value = Resource.error(Exception())
            }
        }

    }
}