package com.example.rickandmortyapi.models

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
@Entity
data class CharacterModel(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("gender")
    val gender: String,
): java.io.Serializable

