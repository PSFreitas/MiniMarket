package com.example.data.network.service

import com.example.data.network.response.ProductResponse
import okhttp3.HttpUrl
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ProductService {

    @GET("59b6a65a0f0000e90471257d")
    suspend fun getAllProducts(): Response<ProductResponse>

    companion object Factory {
        private const val BASE_URL = "http:www.mocky.io/v2/"

        fun create(baseUrl: HttpUrl = HttpUrl.parse(BASE_URL)!!): ProductService {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build()
                .create(ProductService::class.java)
        }

    }
}