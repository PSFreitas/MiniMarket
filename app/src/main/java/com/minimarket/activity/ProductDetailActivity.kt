package com.minimarket.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.minimarket.R
import com.minimarket.databinding.ActivityProductDetailBinding
import com.minimarket.entity.ProductViewEntity

class ProductDetailActivity : AppCompatActivity() {

    private val productDetailViewModel by lazy {
        ViewModelProvider(
            this,
            ProductDetailViewModelFactory()
        ).get(
            ProductDetailViewModel::class.java
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityProductDetailBinding>(
            this,
            R.layout.activity_product_detail
        ).let {
            it.viewModel = productDetailViewModel
        }
    }

    override fun onResume() {
        super.onResume()

        if (intent.hasExtra("SELECTED_PRODUCT"))
            productDetailViewModel.setProduct(intent.getParcelableExtra<ProductViewEntity>("SELECTED_PRODUCT"))
    }
}