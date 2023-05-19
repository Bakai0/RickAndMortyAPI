package com.example.rickandmortyapi.ui.fragments.character.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapi.App
import com.example.rickandmortyapi.models.CharacterModel
import retrofit2.Callback
import retrofit2.Response

class SingleViewModel : ViewModel() {

    fun fetchSingleCharacter(id: Int): MutableLiveData<CharacterModel> {
        val data: MutableLiveData<CharacterModel> = MutableLiveData()
        App.characterApi?.fetchSingleCharacter(id)
            ?.enqueue(object : Callback<CharacterModel> {
                override fun onResponse(
                    call: retrofit2.Call<CharacterModel>,
                    response: Response<CharacterModel>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: retrofit2.Call<CharacterModel>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}