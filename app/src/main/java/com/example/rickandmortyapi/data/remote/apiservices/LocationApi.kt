package com.example.rickandmortyapi.data.remote.apiservices

import com.example.rickandmortyapi.models.LocationModel
import com.example.rickandmortyapi.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationApi {

    @GET("location")
    fun fetchLocations(
        @Query("page") page:Int
    ): Call<RickAndMortyResponse<LocationModel>>
}