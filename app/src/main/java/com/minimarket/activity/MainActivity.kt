package com.minimarket.activity


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxItemDecoration
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.minimarket.R
import com.minimarket.network.service.ProductResponse
import com.minimarket.network.service.ProductService
import com.minimarket.ui.adapter.ProductAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getAllProducts()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val flexBox = FlexboxLayoutManager(this)
        flexBox.flexDirection = FlexDirection.ROW
        flexBox.justifyContent = JustifyContent.SPACE_AROUND

        val itemDecoration = FlexboxItemDecoration(this)
        itemDecoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.product_decorator))
        itemDecoration.setOrientation(FlexboxItemDecoration.HORIZONTAL)


        recyclerView_products.addItemDecoration(itemDecoration)
        recyclerView_products.layoutManager = flexBox

    }

    private fun getAllProducts() {
        val call = ProductService.create().getAllProducts()
        call.enqueue(object : Callback<ProductResponse> {
            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "FALHOU", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                if (response.isSuccessful) {
                    val products = response.body()?.products
                    if (products != null) {
                        productAdapter = ProductAdapter(products, this@MainActivity)
                        recyclerView_products.adapter = productAdapter
                        productAdapter.notifyDataSetChanged()
                    }

                }
                Toast.makeText(this@MainActivity, "DEU BOM", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
