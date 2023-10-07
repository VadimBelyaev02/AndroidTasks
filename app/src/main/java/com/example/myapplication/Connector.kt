package com.example.myapplication

import Venue
import VenuesResponse
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Connector {


    suspend fun connect(): List<Venue> = withContext(Dispatchers.IO) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.foursquare.com/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(buildHttpClient())
            .build()

        val foursquareApiService = retrofit.create(FoursquareApiService::class.java)


        val call = foursquareApiService.searchVenues(
            "FMOHJVYS3P34HKNKKD5QGMM1L0QHTRL5TOJRXKRIZPVPUYHF",
            "GZBHA5HRS1ONH4FVGUWIURQV3FT25AZAB5SQAUGWML305JPS",
            "53.9057644,27.5582305"
        )
        var response : Response<VenuesResponse>? = null
        try {
            response = call.execute()
        } catch (e: Throwable) {
            println(e.message)
        }
        if (response != null && response.isSuccessful) {
            val venuesResponse = response.body()
            return@withContext     venuesResponse?.results ?: emptyList()
        } else {
            return@withContext emptyList()
        }

        //val call = foursquareApiService.searchVenues("53.9057644,27.5582305", 4000, 30)
//        call.enqueue(object : retrofit2.Callback<VenuesResponse> {
//            override fun onResponse(call: Call<VenuesResponse>, response: Response<VenuesResponse>) {
//                if (response.isSuccessful) {
//                    val venuesResponse = response.body()
//                    println("Body: $venuesResponse")
//
//                    Log.v("PIZDA", "$venuesResponse")
//                    result = venuesResponse?.results ?: arrayListOf()
//                } else {
//
//                }
//                println(response.message())
//            }
//
//            override fun onFailure(call: Call<VenuesResponse>, t: Throwable) {
//                println(t.message)
//            }
//        })
//        return result
    }

    private fun buildHttpClient(): OkHttpClient {
        val client = OkHttpClient()
            .newBuilder()
            .addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .header("Authorization", "fsq3eOIQZVztuFwQXqCe8Udfvz1jsBWY8g3hRa3NinqX+PU=")
                    .method(original.method(), original.body())
                val request = requestBuilder.build()
                chain.proceed(request)
            }.build()
        return client
    }
}