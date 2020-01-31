package com.minimarket.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.minimarket.R
import com.minimarket.network.service.ProductResponse
import com.minimarket.network.service.ProductService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getAllProducts()
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
                        for (product in products)
                            Log.i("PRODUTO", product.name)
                    }

                }
                Toast.makeText(this@MainActivity, "DEU BOM", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
