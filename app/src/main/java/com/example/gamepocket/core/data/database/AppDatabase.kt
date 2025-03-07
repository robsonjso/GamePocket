package com.example.gamepocket.core.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gamepocket.core.data.database.FavoriteGameEntity
import com.example.gamepocket.core.data.database.GameDao

// Classe de banco de dados Room
@Database(entities = [FavoriteGameEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao

    // Padrão Singleton para obter a instância do banco de dados
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Método para obter a instância do banco de dados
        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "game_pocket_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
