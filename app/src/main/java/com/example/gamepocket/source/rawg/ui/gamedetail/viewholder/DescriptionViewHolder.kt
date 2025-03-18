package com.example.gamepocket.source.rawg.ui.gamedetail.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.gamepocket.databinding.ItemGameDetailDescriptionComponentBinding

import com.example.gamepocket.source.rawg.ui.gamedetail.component.description.DescriptionUIModel

class DescriptionViewHolder(private val binding: ItemGameDetailDescriptionComponentBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: DescriptionUIModel) {
        binding.root.initialize(item)
    }
}