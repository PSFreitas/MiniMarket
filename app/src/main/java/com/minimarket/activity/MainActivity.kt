package com.minimarket.activity


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.minimarket.R
import com.minimarket.activity.adapter.ProductAdapter
import com.minimarket.data.network.repository.ProductRepositoryImplementation
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val productViewModel by lazy {
        val productRepository = ProductRepositoryImplementation()
        ViewModelProvider(
            this,
            ProductViewModelFactory(productRepository)
        ).get(ProductViewModel::class.java)
    }

    private val productAdapter = ProductAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupObservable()
        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        recyclerView_products.apply {
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                RecyclerView.VERTICAL,
                false
            )
            adapter = productAdapter
        }
    }

    private fun setupObservable() {
        productViewModel.productList.observe(
            this,
            Observer {
                if (it != null) {
                    productAdapter.productList.addAll(it)
                }
                productAdapter.notifyDataSetChanged()
            }
        )
    }

    override fun onStart() {
        super.onStart()
        productViewModel.getAllProducts()
    }


}
