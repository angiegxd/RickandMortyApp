package com.example.rickandmortyapp.views.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.utils.dto.Result
import kotlinx.android.synthetic.main.item_rickandmortylist.view.*

class RickAndMortyEpisodesAdapter(val rickandmorty :List<Result>): RecyclerView.Adapter<RickAndMortyEpisodesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RickAndMortyEpisodesAdapter.ViewHolder {
        return RickAndMortyEpisodesAdapter.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rickandmortylist, parent, false)
        )
    }
    override fun onBindViewHolder(holder: RickAndMortyEpisodesAdapter.ViewHolder, position: Int) {
        holder.setViewItem(position, rickandmorty[position])
    }

    override fun getItemCount(): Int {
        return rickandmorty.size
    }
    class ViewHolder (val view: View):RecyclerView.ViewHolder(view){
        fun setViewItem(position: Int, result:Result){
            view.tv_item_character_rickandmorty_list_number.text="$position.-"
            view.tv_item_character_rickandmorty_name.text=result.name
        }
    }
}