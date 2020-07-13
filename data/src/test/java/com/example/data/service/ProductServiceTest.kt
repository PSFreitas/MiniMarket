package com.example.data.service

import com.example.data.network.response.ProductResponse
import com.example.data.network.service.ProductService
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Test
import java.net.HttpURLConnection

class ProductServiceTest {

    private val mockWebServer = MockWebServer()
    private val api = ProductService.create(mockWebServer.url("/"))


    @Test
    fun testList() {
        val bodyInJson = javaClass.classLoader?.getResource("productList.json")?.readText() ?: ""

        val mockResponse = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(bodyInJson)

        mockWebServer.enqueue(mockResponse)

        runBlocking {
            val api = api.getAllProducts()

            assertTrue(api.body() is ProductResponse)

        }

    }

}