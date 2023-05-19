package com.example.rickandmortyapi

import android.app.Application
import com.example.rickandmortyapi.data.remote.RetrofitClient
import com.example.rickandmortyapi.data.remote.apiservices.CharacterApi
import com.example.rickandmortyapi.data.remote.apiservices.EpisodeApi
import com.example.rickandmortyapi.data.remote.apiservices.LocationApi

class App: Application() {

    companion object{
        var characterApi: CharacterApi? = null
        var locationApi: LocationApi? = null
        var episodeApi: EpisodeApi? = null
    }

    override fun onCreate() {
        super.onCreate()
        val retrofitClient = RetrofitClient()
        characterApi = retrofitClient.provideCharacterApiService()
        locationApi = retrofitClient.provideLocationApiServices()
        episodeApi = retrofitClient.provideEpisodeApiServices()
    }
}