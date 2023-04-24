package com.example.rickandmortyapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.utils.api.Resource
import com.example.rickandmortyapp.utils.api.Status
import com.example.rickandmortyapp.utils.dto.Results
import com.example.rickandmortyapp.utils.dto.Result
import com.example.rickandmortyapp.viewmodel.RickAndMortyViewModel
import com.example.rickandmortyapp.views.adapter.RickAndMortyEpisodesAdapter
import com.example.rickandmortyapp.views.adapter.RickAndMortyListAdapter
import kotlinx.android.synthetic.main.character_list.*
import kotlinx.android.synthetic.main.episode_list.*

class EpisodesList : Fragment(){
    private val episodeObserver= Observer<Resource<List<Result>>>{
        when(it.status){
            Status.SUCCESS->{
                val adapter= RickAndMortyEpisodesAdapter(it.data!!)
                rv_rickandmorty_episodes_list.adapter= adapter
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
        return inflater.inflate(R.layout.episode_list, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createObservers()
        viewModel.showEpisodes()
        rv_rickandmorty_episodes_list.layoutManager= LinearLayoutManager(requireContext())
    }

    private fun createObservers() {
        viewModel.episodes.observe(viewLifecycleOwner, episodeObserver)
    }

}