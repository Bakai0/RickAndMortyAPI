package com.example.rickandmortyapi.ui.fragments.character

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortyapi.data.repositories.CharacterRepository
import com.example.rickandmortyapi.models.CharacterModel
import com.example.rickandmortyapi.models.RickAndMortyResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

class SharedViewModel : ViewModel() {

    private val characterRepository = CharacterRepository()
    private val _characterLiveData = MutableSharedFlow<RickAndMortyResponse<CharacterModel>>()
    val charactreLiveData: Flow<RickAndMortyResponse<CharacterModel>> get() = _characterLiveData
    private val _errorLiveData = MutableSharedFlow<String>()
    val errorLiveData: Flow<String> get() = _errorLiveData

    init {
        Log.e("viewModel", "Created")
    }

    fun fetchCharacters() = characterRepository.fetchCharacter().cachedIn(viewModelScope)
    fun fetchSingleCharacter(id: Int): LiveData<CharacterModel> {
        return characterRepository.getSingleCharacter(id)
    }
}
