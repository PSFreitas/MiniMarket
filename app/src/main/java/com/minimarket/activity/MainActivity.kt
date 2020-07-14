package com.minimarket.activity


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.minimarket.R
import com.minimarket.`interface`.OnProductClickListener
import com.minimarket.adapter.ProductAdapter
import com.minimarket.data.network.repository.ProductRepositoryImplementation
import com.minimarket.databinding.ActivityMainBinding
import com.minimarket.domain.entities.ProductEntity
import com.minimarket.valuableobject.Status
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

        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        ).let {
            it.viewModel = productViewModel
            it.lifecycleOwner = this
        }

        fetchProductList()
        setupObservable()
        setupAdapter()
        setupRecyclerView()

    }

    private fun setupAdapter() {
        productAdapter.onProductClickListener = object : OnProductClickListener {
            override fun onProductClick(product: ProductEntity) {
                startActivity(
                    Intent(this@MainActivity, ProductDetailActivity::class.java)
                )
            }

        }
    }

    private fun fetchProductList() {
        productViewModel.getAllProducts()
    }

    private fun setupRecyclerView() {

        val itemDecoration = DividerItemDecoration(
            this@MainActivity,
            RecyclerView.HORIZONTAL
        )

        val pageSnapHelper = PagerSnapHelper()
        pageSnapHelper.attachToRecyclerView(recyclerView_products)

        ContextCompat.getDrawable(this@MainActivity, R.drawable.product_decorator)?.let {
            itemDecoration.setDrawable(
                it
            )
        }

        recyclerView_products.apply {
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                RecyclerView.HORIZONTAL,
                false
            )
            adapter = productAdapter

            addItemDecoration(itemDecoration)
        }


    }

    private fun setupObservable() {
        productViewModel.productList.observe(
            this,
            Observer {
                if (it.status == Status.SUCCESS)
                    productAdapter.productList.addAll(it.data!!)
                productAdapter.notifyDataSetChanged()
            }
        )
    }
}
