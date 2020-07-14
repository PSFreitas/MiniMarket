package com.minimarket.activity


import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
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
import com.minimarket.entity.ProductViewEntity
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
            override fun onProductClick(product: ProductViewEntity, imageView: ImageView) {
                val intent = Intent(this@MainActivity, ProductDetailActivity::class.java)
                intent.putExtra("SELECTED_PRODUCT", product)

                val options = ActivityOptions
                    .makeSceneTransitionAnimation(
                        this@MainActivity,
                        imageView,
                        ViewCompat.getTransitionName(imageView  )
                    )
                startActivity(intent, options.toBundle())

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

        ContextCompat.getDrawable(this@MainActivity, R.drawable.product_decorator)?.let {
            itemDecoration.setDrawable(
                it
            )
        }
        val pageSnapHelper = PagerSnapHelper()
        pageSnapHelper.attachToRecyclerView(recyclerView_products)



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
