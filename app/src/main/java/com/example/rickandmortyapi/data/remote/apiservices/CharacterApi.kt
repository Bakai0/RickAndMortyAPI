package com.example.rickandmortyapi.data.remote.apiservices

import com.example.rickandmortyapi.models.CharacterModel
import com.example.rickandmortyapi.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApi {

    @GET("character")
    fun fetchCharacters(): Call<RickAndMortyResponse<CharacterModel>>

    @GET ("api/character/{id}")
    fun fetchSingleCharacter (
        @Path("id") id: Int
    ): Call<CharacterModel>
}