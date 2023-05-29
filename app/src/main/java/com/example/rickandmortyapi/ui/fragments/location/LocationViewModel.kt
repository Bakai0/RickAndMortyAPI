package com.example.rickandmortyapi.ui.fragments.location

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortyapi.data.repositories.LocationRepository
import com.example.rickandmortyapi.models.LocationModel
import com.example.rickandmortyapi.models.RickAndMortyResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

class LocationViewModel : ViewModel() {

    private val locationRepository = LocationRepository()
    private val _locationFlow = MutableSharedFlow<RickAndMortyResponse<LocationModel>>()
    val locationFlow : Flow<RickAndMortyResponse<LocationModel>> get() = _locationFlow
    private val _errorFlow = MutableSharedFlow<String>()
    val errorFlow: Flow<String> get() = _errorFlow

    init {
        Log.e("viewModel", "Created")
    }

    fun fetchLocation() = locationRepository.fetchLocation().cachedIn(viewModelScope)
}

