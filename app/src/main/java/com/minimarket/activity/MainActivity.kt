package com.minimarket.activity


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.data.network.repository.ProductRepositoryImplementation
import com.minimarket.R


class MainActivity : AppCompatActivity() {

    private val productViewModel by lazy {
        val productRepository = ProductRepositoryImplementation()
        ViewModelProvider(
            this,
            ProductViewModelFactory(productRepository)
        ).get(ProductViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupObservable()

    }

    private fun setupObservable() {
        productViewModel.productList.observe(
            this,
            Observer {
                if (it != null) {

                }
            }
        )
    }

    override fun onResume() {
        super.onResume()
        productViewModel.getAllProducts()
    }


}
