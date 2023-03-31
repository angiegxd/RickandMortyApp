package com.example.rickandmortyapp

import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController

class CharactersList : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    fun addActions(){
        requireView().findViewById<ListView>(R.id.lv_Characters).setOnClickListener {
            findNavController().navigate(R.id.action_charactersList_to_charactersDetails)
        }

    }
}