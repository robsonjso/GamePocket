package com.example.gamepocket.core.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

// Entidade para representar um jogo favorito no banco de dados
@Entity(tableName = "favorite_games")
// Classe de dados para representar um jogo favorito
data class FavoriteGameEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val releaseDate: String
)
