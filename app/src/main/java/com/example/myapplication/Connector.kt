package com.example.myapplication


import Venue
import VenuesResponse
import android.content.Context
import com.foursquare.android.nativeoauth.FoursquareOAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Connector(private val context: Context) {

    private val clientSecret = "GZBHA5HRS1ONH4FVGUWIURQV3FT25AZAB5SQAUGWML305JPS"

    private val clientId = "FMOHJVYS3P34HKNKKD5QGMM1L0QHTRL5TOJRXKRIZPVPUYHF"
    fun register() {
        val connectIntent = FoursquareOAuth.getConnectIntent(context, clientId)
        val retrofit = buildRetrofit("https://foursquare.com/oauth2/", HashMap())

        val foursquareApiService = retrofit.create(FoursquareApiService::class.java)

    //    val call = foursquareApiService.authenticate(clientId, "code", "myapp://auth_callback")

      //  var response = call.execute()
     //   println(response)
//        println(response.message())
//        println(response.body())
//        println(response.errorBody())

    }


    suspend fun connect(): List<Venue> = withContext(Dispatchers.IO) {
        val headers = HashMap<String, String>()
        headers["Authorization"] = "fsq3eOIQZVztuFwQXqCe8Udfvz1jsBWY8g3hRa3NinqX+PU="
        val retrofit = buildRetrofit("https://api.foursquare.com/v3/", headers)

        val foursquareApiService = retrofit.create(FoursquareApiService::class.java)

        val call = foursquareApiService.searchVenues( "53.9057644,27.5582305", 4000, 30)
        var response: Response<VenuesResponse>? = null
        try {
            response = call.execute()
        } catch (e: Throwable) {
            println(e.message)
        }
        if (response != null && response.isSuccessful) {
            val venuesResponse = response.body()
            return@withContext venuesResponse?.results ?: emptyList()
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

    private fun buildRetrofit(url: String, headers: Map<String, String>): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(buildHttpClient(headers))
            .build()
    }

    private fun buildHttpClient(headers: Map<String, String>): OkHttpClient {
        val client = OkHttpClient()
            .newBuilder()
            .addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                for ((key, value) in headers) {
                    requestBuilder.addHeader(key, value)
                }
                // .header("Authorization", "fsq3eOIQZVztuFwQXqCe8Udfvz1jsBWY8g3hRa3NinqX+PU=")
                requestBuilder.method(original.method(), original.body())
                val request = requestBuilder.build()
                chain.proceed(request)
            }.build()
        return client
    }
}