package com.synthesizer.source.rawg.ui.gamedetail.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.gamepocket.databinding.ItemGameDetailSummaryComponentBinding

import com.example.gamepocket.source.rawg.ui.gamedetail.component.summary.SummaryUIModel

class SummaryViewHolder(private val binding: ItemGameDetailSummaryComponentBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: SummaryUIModel) {
        binding.root.initialize(item)
    }
}