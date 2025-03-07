package com.example.gamepocket.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

// Classe de banco de dados Room para jogos
@Database(entities = [FavoriteGameEntity::class], version = 1)
// Classe abstrata para o banco de dados Room
abstract class GameDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao
}
