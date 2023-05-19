package com.example.rickandmortyapi.data.remote.apiservices

import com.example.rickandmortyapi.models.EpisodeModel
import com.example.rickandmortyapi.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface EpisodeApi {

    @GET("episode")
    fun fetchEpisodes(): Call<RickAndMortyResponse<EpisodeModel>>
}