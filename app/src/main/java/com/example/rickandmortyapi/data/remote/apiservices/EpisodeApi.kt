package com.example.rickandmortyapi.data.remote.apiservices

import com.example.rickandmortyapi.models.CharacterModel
import com.example.rickandmortyapi.models.EpisodeModel
import com.example.rickandmortyapi.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodeApi {

    @GET("episode")
    fun fetchEpisodes(
        @Query("page") page:Int
    ): Call<RickAndMortyResponse<EpisodeModel>>

    @GET ("api/character/{id}")
    fun fetchSingleEpisode (
        @Path("id") id: Int
    ): Call<CharacterModel>

}