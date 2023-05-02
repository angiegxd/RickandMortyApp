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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.utils.api.Resource
import com.example.rickandmortyapp.utils.api.Status
import com.example.rickandmortyapp.utils.dto.Results
import com.example.rickandmortyapp.viewmodel.RickAndMortyViewModel
import com.example.rickandmortyapp.views.adapter.RickAndMortyListAdapter
import kotlinx.android.synthetic.main.character_list.*

class CharactersList : Fragment() {
    private val characterObserver = Observer<Resource<List<Results>>> {
        when (it.status) {
            Status.SUCCESS -> {
                val adapter = RickAndMortyListAdapter(it.data!!, object : RickAndMortyListAdapter.OnItemClickListener{
                    override fun onItemClick(position: Int) {
                        viewModel.setSelectedItemRyM(position)
                        findNavController().navigate(R.id.action_charactersList_to_charactersDetails)
                    }

                })
                rv_rickandmorty_list.adapter = adapter
            }
            Status.ERROR -> {

            }
            Status.LOADING -> {

            }
        }
    }
    private lateinit var viewModel: RickAndMortyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(RickAndMortyViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.character_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createObservers()
        addActions()
        viewModel.showCharacters()
        rv_rickandmorty_list.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun createObservers() {
        viewModel.characters.observe(viewLifecycleOwner, characterObserver)
    }

    fun addActions() {
        btn_fragment_rickandmorty_sig.setText("Continuar Episodes")
        btn_fragment_rickandmorty_sig.setOnClickListener {
            findNavController().navigate(R.id.action_charactersList_to_episodesList)
        }
    }
}