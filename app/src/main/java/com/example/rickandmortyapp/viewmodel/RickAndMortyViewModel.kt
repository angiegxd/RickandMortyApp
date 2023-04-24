package com.example.rickandmortyapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.repository.RickAndMortyRepository
import com.example.rickandmortyapp.utils.api.Resource
import com.example.rickandmortyapp.utils.dto.Results
import com.example.rickandmortyapp.utils.dto.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RickAndMortyViewModel : ViewModel(){
private val repository= RickAndMortyRepository()
    val characters = MutableLiveData<Resource<List<Results>>>()
    val episodes =MutableLiveData<Resource<List<Result>>>()

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
}