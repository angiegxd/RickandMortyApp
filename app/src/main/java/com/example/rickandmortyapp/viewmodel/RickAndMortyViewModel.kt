package com.example.rickandmortyapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.repository.RickAndMortyRepository
import com.example.rickandmortyapp.utils.api.Resource
import com.example.rickandmortyapp.utils.api.Status
import com.example.rickandmortyapp.utils.dto.Origin
import com.example.rickandmortyapp.utils.dto.Results
import com.example.rickandmortyapp.utils.dto.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RickAndMortyViewModel : ViewModel(){
private val repository= RickAndMortyRepository()
    val characters = MutableLiveData<Resource<List<Results>>>()
    val episodes =MutableLiveData<Resource<List<Result>>>()
    val detail = MutableLiveData<Resource<Results>>()
    val detail2 = MutableLiveData<Resource<Origin>>()

    fun showCharacters(){
        viewModelScope.launch {
            val result = repository.getRickAndMortyCharacters()
            withContext(Dispatchers.Main){
                characters.value=result
            }
        }
    }
    fun showEpisodes(){
        viewModelScope.launch {
            val result2 = repository.getRickAndMortyEpisodes()
            withContext(Dispatchers.Main){
                episodes.value=result2
            }
        }
    }

    fun setSelectedItemRyM(position: Int) {
        val rym= characters.value!!.data!![position]
        Log.i(this.javaClass.simpleName, "${rym.name}")
        detail.value= Resource(Status.SUCCESS, rym, null)
    }
}