package com.example.gamepocket.source.rawg.ui.gamelist

import androidx.recyclerview.widget.RecyclerView
import com.example.gamepocket.databinding.ItemGameListBinding

import com.example.gamepocket.source.rawg.domain.model.GameListItem

class GameListViewHolder(
    val binding: ItemGameListBinding,
    private val clickListener: (Int) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: GameListItem) {
        binding.root.apply {
            initialize(item)
            setOnClickListener {
                clickListener(item.id)
            }
        }
    }

    fun clearImage(){
        binding.root.clearImage()
    }
}