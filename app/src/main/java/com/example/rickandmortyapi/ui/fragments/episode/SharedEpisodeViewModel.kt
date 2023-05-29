package com.example.rickandmortyapi.ui.fragments.episode

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortyapi.data.repositories.EpisodeRepository
import com.example.rickandmortyapi.models.EpisodeModel
import com.example.rickandmortyapi.models.RickAndMortyResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

class SharedEpisodeViewModel : ViewModel() {

    private val episodeRepository = EpisodeRepository()
    private val _cepisodeFlow = MutableSharedFlow<RickAndMortyResponse<EpisodeModel>>()
    val episodeFlow : Flow<RickAndMortyResponse<EpisodeModel>> get() = _cepisodeFlow
    private val _errorFlow = MutableSharedFlow<String>()
    val errorFlow: Flow<String> get() = _errorFlow

    init {
        Log.e("viewModel", "Created")
    }

    fun fetchEpisode() = episodeRepository.fetchEpisode().cachedIn(viewModelScope)
}
