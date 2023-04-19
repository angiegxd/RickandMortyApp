package com.example.rickandmortyapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.utils.api.Resource
import com.example.rickandmortyapp.utils.api.Status
import com.example.rickandmortyapp.utils.dto.Results
import com.example.rickandmortyapp.viewmodel.RickAndMortyViewModel
import kotlinx.android.synthetic.main.character_list.*

class CharactersList : Fragment() {
    private val characterObserver= Observer<Resource<List<Results>>>{
        when(it.status){
            Status.SUCCESS->{

            }
            Status.ERROR->{

            }
            Status.LOADING->{

            }
        }
    }
    private lateinit var viewModel: RickAndMortyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel= ViewModelProvider(requireActivity()).get(RickAndMortyViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.character_list, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_character_list.setOnClickListener {
            findNavController().navigate(R.id.action_charactersList_to_charactersDetails)
        }
        viewModel.showCharacters()
        viewModel.characters.observe(viewLifecycleOwner, characterObserver)
    }
}