package com.example.rickandmortyapp.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.utils.api.Resource
import com.example.rickandmortyapp.utils.api.Status
import com.example.rickandmortyapp.utils.dto.Origin
import com.example.rickandmortyapp.utils.dto.Results
import com.example.rickandmortyapp.viewmodel.RickAndMortyViewModel
import kotlinx.android.synthetic.main.details_characters.*

class CharactersDetails : Fragment() {
    @SuppressLint("SetTextI18n")
    private val detailObserver = Observer<Resource<Results>>{
        when (it.status) {
            Status.SUCCESS -> {
                it.data
                tv_rickandmorty_details_name.text= it.data!!.name
                tv_rickandmorty_details_status.text= it.data.status
                tv_rickandmorty_details_species.text= it.data.species
                tv_rickandmorty_details_type.text= it.data.type
                tv_rickandmorty_details_gender.text= it.data.gender
                tv_rickandmorty_details_origin.text= it.data.origin.name + "\n" + it.data.origin.url
                tv_rickandmorty_details_location.text= it.data.location.name + "\n" +  it.data.location.url
                tv_rickandmorty_details_episode.text= it.data.episode.toString()
                tv_rickandmorty_details_url.text= it.data.url
                tv_rickandmorty_details_created.text= it.data.created
                val imageUrl = it.data.image

                Glide.with(requireContext())
                    .load(imageUrl)
                    .into(iv_rickandmorty_details_img)
            }
            Status.ERROR -> {

            }
            Status.LOADING -> {

            }
        }
    }
    private val detailObserver2 = Observer<Resource<Origin>>{
        when (it.status) {
            Status.SUCCESS -> {
                it.data
    //tv_rickandmorty_details_origin.text= it.data!!.name
    //tv_rickandmorty_details_location.text= it.data.location.name
    //
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
        return inflater.inflate(R.layout.details_characters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createObservers()
        addActions()
        viewModel.showCharacters()


    }

    private fun createObservers() {
        viewModel.detail.observe(viewLifecycleOwner, detailObserver)
        viewModel.detail2.observe(viewLifecycleOwner, detailObserver2)
    }

    fun addActions() {

    }
}