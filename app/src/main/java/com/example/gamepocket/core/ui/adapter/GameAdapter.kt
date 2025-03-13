package com.example.gamepocket.core.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gamepocket.core.data.model.Game
import com.example.gamepocket.databinding.ItemGameBinding // Import correto

// Adaptador para a lista de jogos
class GameAdapter(
    // Passe a função onClick como parâmetro
    private val onClick: (Game) -> Unit
) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    private val games = mutableListOf<Game>()

    fun submitList(newList: List<Game>) {
        games.clear()
        games.addAll(newList)
        notifyDataSetChanged()
    }

    // Inflar o layout do item da lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GameViewHolder(ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) = holder.bind(games[position])

    override fun getItemCount() = games.size

    // ViewHolder para cada item da lista de jogos
    inner class GameViewHolder(private val binding: ItemGameBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(game: Game) {
            binding.gameTitle.text = game.name
            Glide.with(binding.gameImage.context).load(game.backgroundImage).into(binding.gameImage)
            binding.root.setOnClickListener { onClick(game) }
        }
    }
}
