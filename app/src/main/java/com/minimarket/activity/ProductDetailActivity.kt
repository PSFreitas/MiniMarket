package com.minimarket.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.minimarket.R
import com.minimarket.adapter.SizeAdapter
import com.minimarket.databinding.ActivityProductDetailBinding
import com.minimarket.entity.ProductViewEntity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {

    private val sizeAdapter = SizeAdapter(mutableListOf())

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

        setupToolbar()

        retrieveProduct()
        loadImage()

    }

    private fun loadImage() {


        if (productDetailViewModel.productViewEntity.value!!.image.isNotBlank() &&
            productDetailViewModel.productViewEntity.value!!.image.isNotEmpty()
        )
            Picasso
                .get()
                .load(productDetailViewModel.productViewEntity.value!!.image)
                .placeholder(android.R.color.white)
                .error(android.R.color.white)
                .into(imageView_product_detail_image, object : Callback {
                    override fun onSuccess() {
                        startPostponedEnterTransition()
                    }

                    override fun onError(e: Exception?) {
                        startPostponedEnterTransition()
                    }

                })
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar_product_detail)

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar_product_detail.setNavigationOnClickListener {
            onBackPressed()
        }

    }

    override fun onResume() {
        super.onResume()
        setupObservers()
        setupRecyclerView()

    }

    private fun setupRecyclerView() {

        val itemDecoration = DividerItemDecoration(
            this@ProductDetailActivity,
            RecyclerView.HORIZONTAL
        )
        ContextCompat.getDrawable(this@ProductDetailActivity, R.drawable.size_decorator)?.let {
            itemDecoration.setDrawable(
                it
            )
        }

        recyclerView_size_product.apply {
            layoutManager = LinearLayoutManager(
                this@ProductDetailActivity,
                RecyclerView.HORIZONTAL,
                false
            )
            adapter = sizeAdapter
            addItemDecoration(itemDecoration)
        }
    }

    private fun retrieveProduct() {
        if (intent.hasExtra("SELECTED_PRODUCT"))
            productDetailViewModel.setProduct(intent.getParcelableExtra<ProductViewEntity>("SELECTED_PRODUCT"))
    }

    private fun setupObservers() {
        productDetailViewModel.productViewEntity.observe(
            this,
            Observer {
                if (it != null) {
                    sizeAdapter.sizes = it.existentSizes
                    sizeAdapter.notifyDataSetChanged()
                }
            }
        )
    }
}
