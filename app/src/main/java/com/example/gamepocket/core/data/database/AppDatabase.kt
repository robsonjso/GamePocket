package com.example.gamepocket.core.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gamepocket.core.data.database.FavoriteGameEntity
import com.example.gamepocket.core.data.database.GameDao

@Database(entities = [FavoriteGameEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

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
