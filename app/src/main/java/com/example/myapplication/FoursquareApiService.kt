package com.example.myapplication

import VenuesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface FoursquareApiService {
    @GET("places/search")
    fun searchVenues(
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String,
        @Query("ll") location: String,
       // @Query("radius") radius: Int,
        //@Query("limit") limit: Int
    ): Call<VenuesResponse>
}
