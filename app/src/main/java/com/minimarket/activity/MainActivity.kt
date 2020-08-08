package com.minimarket.activity


import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
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
import com.minimarket.`interface`.OnBuyProductClickListener
import com.minimarket.`interface`.OnProductClickListener
import com.minimarket.adapter.ProductAdapter
import com.minimarket.data.network.repository.ProductRepositoryImplementation
import com.minimarket.databinding.ActivityMainBinding
import com.minimarket.entity.ProductViewEntity
import com.minimarket.valuableobject.Status
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Pair as UtilPair

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
        setupToolbar()
        setupCartCount()
    }

    private fun setupCartCount() {
        productViewModel.setupCartCount()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar_product_list)
    }

    private fun setupAdapter() {

        productAdapter.onProductClickListener = object : OnProductClickListener {
            override fun onProductClick(
                product: ProductViewEntity,
                imageView: ImageView,
                addCartView: View
            ) {
                val intent = Intent(this@MainActivity, ProductDetailActivity::class.java)
                intent.putExtra("SELECTED_PRODUCT", product)

                val options = ActivityOptions
                    .makeSceneTransitionAnimation(
                        this@MainActivity,
                        UtilPair.create<View, String>(
                            imageView,
                            ViewCompat.getTransitionName(imageView)
                        ),
                        UtilPair.create<View, String>(
                            addCartView,
                            ViewCompat.getTransitionName(addCartView)
                        )
                    )
                startActivity(intent, options.toBundle())

            }
        }

        productAdapter.onBuyProductClickListener = object : OnBuyProductClickListener {
            override fun onBuyProductClickListener(product: ProductViewEntity) {
                Toast.makeText(this@MainActivity, R.string.product_added, Toast.LENGTH_SHORT).show()
                productViewModel.increaseCartCount()
                productViewModel.increaseCartTotalPrice(product.actualPrice)
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

        productViewModel.cartCount.observe(
            this,
            Observer {
                if (it != 0 && materialCardView_cart.visibility != View.VISIBLE) {
                    val slideUp: Animation =
                        AnimationUtils.loadAnimation(this, R.anim.slide_in_vertical)
                    materialCardView_cart.visibility = View.VISIBLE
                    materialCardView_cart.startAnimation(slideUp)
                }
            }
        )
    }
}
