package com.minimarket.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.minimarket.R
import com.minimarket.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityProductDetailBinding>(
            this,
            R.layout.activity_product_detail
        )
    }
}