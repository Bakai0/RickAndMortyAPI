package com.example.rickandmortyapi.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.rickandmortyapi.models.CharacterModel
import retrofit2.http.Query

interface CharacterDao {

    @Query("SELECT * FROM characterModel")
    fun getAll(): LiveData<List<CharacterModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(characterModel: List<CharacterModel>)
}