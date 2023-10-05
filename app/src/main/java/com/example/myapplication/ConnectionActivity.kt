package com.example.myapplication

import VenuesResponse
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import okhttp3.Callback
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConnectionActivity : AppCompatActivity() {

    private lateinit var connectionButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connection)

        connectionButton = findViewById(R.id.connectionButton)

        //connectionButton.setBackgroundColor(getColor(R.color.blue))

        connectionButton.setOnClickListener {
            searchVenues()
        }
    }

    private fun searchVenues() {
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

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.foursquare.com/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        val foursquareApiService = retrofit.create(FoursquareApiService::class.java)


        val call = foursquareApiService.searchVenues("53.9057644,27.5582305", 4000, 30)
        call.enqueue(object : retrofit2.Callback<VenuesResponse> {
            override fun onResponse(call: Call<VenuesResponse>, response: Response<VenuesResponse>) {
                if (response.isSuccessful) {
                    // Обработка успешного ответа от сервера
                    val venuesResponse = response.body()

                    // Дальнейшая обработка данных
                } else {

                    // Обработка ошибки
                }
            }

            override fun onFailure(call: Call<VenuesResponse>, t: Throwable) {
                // Обработка ошибки сети или других проблем
            }
        })
    }
}
