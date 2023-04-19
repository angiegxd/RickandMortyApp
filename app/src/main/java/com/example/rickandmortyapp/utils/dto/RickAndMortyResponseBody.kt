package com.example.rickandmortyapp.utils.dto

import com.google.gson.annotations.SerializedName

data class RickAndMortyResponseBody (

    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Results>
)