package com.example.rickandmortyapp.views.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.utils.dto.Results
import kotlinx.android.synthetic.main.item_rickandmortylist.view.*

class RickAndMortyListAdapter(val rickandmorty :List<Results>, val listener : OnItemClickListener): RecyclerView.Adapter<RickAndMortyListAdapter.ViewHolder>() {
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RickAndMortyListAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rickandmortylist, parent, false))
    }

    override fun onBindViewHolder(holder: RickAndMortyListAdapter.ViewHolder, position: Int) {
        holder.setViewItem(position, rickandmorty[position], listener)
    }

    override fun getItemCount(): Int {
        return rickandmorty.size
    }
    class ViewHolder(val view: View):RecyclerView.ViewHolder(view){
        fun setViewItem(position: Int, result: Results, listener: OnItemClickListener){
            view.tv_item_character_rickandmorty_list_number.text="$position.-"
            view.tv_item_character_rickandmorty_name.text=result.name
            view.cv_item_rickandmorty_container.setOnClickListener {
                listener.onItemClick(position)
            }
        }

    }
}