package com.example.gamepocket.source.rawg.ui.gamedetail.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.gamepocket.databinding.ItemGameDetailHeaderComponentBinding

import com.example.gamepocket.source.rawg.ui.gamedetail.component.header.HeaderUIModel

class HeaderViewHolder(private val binding: ItemGameDetailHeaderComponentBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: HeaderUIModel) {
        binding.root.initialize(item)
    }
}