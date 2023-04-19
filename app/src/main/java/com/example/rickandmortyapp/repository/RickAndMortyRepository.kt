package com.example.rickandmortyapp.repository

import com.example.rickandmortyapp.App
import com.example.rickandmortyapp.BuildConfig
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.utils.api.*
import com.example.rickandmortyapp.utils.dto.Results

class RickAndMortyRepository {
    private val service = RequestManager(BuildConfig.BASE_URL).create(ApiService::class.java)
    private val application = App.instance

    suspend fun getRickAndMortyCharacters():Resource<List<Results>> {
        return try {
    val response=service.getRickandMortyList(application.getString(R.string.service_characters))
            Resource(Status.SUCCESS, response.body()!!.results, null)
        } catch (e: Exception) {
    Resource(Status.ERROR,  null, ErrorModel(ErrorModel.Type.TOLERABLE, "Algo salió mal x.x"))
        }
    }
}