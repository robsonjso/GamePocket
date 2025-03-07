package com.example.gamepocket.core.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

// Interface para acessar o banco de dados Room
@Dao
interface GameDao {
    // Operações de banco de dados para jogos favoritos
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToFavorites(game: FavoriteGameEntity)

    @Delete
    suspend fun removeFromFavorites(game: FavoriteGameEntity)

    @Query("SELECT * FROM favorite_games")
    suspend fun getFavoriteGames(): List<FavoriteGameEntity>
}
