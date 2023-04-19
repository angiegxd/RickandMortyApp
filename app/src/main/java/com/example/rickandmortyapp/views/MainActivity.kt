package com.example.rickandmortyapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.viewmodel.RickAndMortyViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel:RickAndMortyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel=ViewModelProvider(this).get(RickAndMortyViewModel::class.java)
    }
}