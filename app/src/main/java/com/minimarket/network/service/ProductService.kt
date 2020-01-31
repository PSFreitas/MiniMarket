package com.minimarket.network.service

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ProductService {

    @GET("59b6a65a0f0000e90471257d")
    fun getAllProducts(): Call<ProductResponse>

    companion object Factory {
        private const val BASE_URL = "http:www.mocky.io/v2/"

        fun create(): ProductService {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(ProductService::class.java)
        }

    }
}