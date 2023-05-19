package com.example.rickandmortyapi.ui.fragments.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapi.App
import com.example.rickandmortyapi.models.LocationModel
import com.example.rickandmortyapi.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationViewModel : ViewModel() {

    fun fetchLocations(): MutableLiveData<RickAndMortyResponse<LocationModel>?> {
        val data = MutableLiveData<RickAndMortyResponse<LocationModel>?>()

        App.locationApi?.fetchLocations()
            ?.enqueue(object : Callback<RickAndMortyResponse<LocationModel>> {

                override fun onResponse(
                    call: Call<RickAndMortyResponse<LocationModel>>,
                    response: Response<RickAndMortyResponse<LocationModel>>
                ) {
                    if (response.isSuccessful)
                        data.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<LocationModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}