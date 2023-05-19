package com.example.rickandmortyapi.data.remote

import com.example.rickandmortyapi.data.remote.apiservices.CharacterApi
import com.example.rickandmortyapi.data.remote.apiservices.EpisodeApi
import com.example.rickandmortyapi.data.remote.apiservices.LocationApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideCharacterApiService(): CharacterApi {
        return retrofitClient.create(CharacterApi::class.java)
    }

    fun provideLocationApiServices(): LocationApi {
        return retrofitClient.create(LocationApi::class.java)
    }

    fun provideEpisodeApiServices(): EpisodeApi {
        return retrofitClient.create(EpisodeApi::class.java)
    }
}