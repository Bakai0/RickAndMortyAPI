package com.example.rickandmortyapi.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmortyapi.App
import com.example.rickandmortyapi.data.repositories.pagingsources.LocationPagingSources
import com.example.rickandmortyapi.models.LocationModel
import kotlinx.coroutines.flow.Flow

class LocationRepository {

    fun fetchLocation(): Flow<PagingData<LocationModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                LocationPagingSources(App.locationApi!!)
            }).flow
    }
}