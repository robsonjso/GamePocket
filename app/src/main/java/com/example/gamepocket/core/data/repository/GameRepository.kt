package com.example.gamepocket.core.data.repository


import com.example.gamepocket.core.util.Constants
import com.example.gamepocket.core.data.api.GameApiService
import com.example.gamepocket.core.data.database.FavoriteGameEntity
import com.example.gamepocket.core.data.database.GameDao
import com.example.gamepocket.core.data.model.Game
import com.example.gamepocket.core.data.model.GameDetail

// Repositório para a API
class GameRepository(private val api: GameApiService, private val dao: GameDao) {

    // Funções para acessar a API
    suspend fun getGames(search: String?, ordering: String?, genres: String?): List<Game> {
        return api.getGames(Constants.API_KEY, search, ordering, genres).results
    }

    // Funções para acessar o banco de dados local de jogos favoritos
    suspend fun getGameDetail(gameId: Int): GameDetail {
        return api.getGameDetail(gameId, Constants.API_KEY)
    }

    // Funções para acessar a API de jogos recomendados
    suspend fun getSuggestedGames(gameId: Int): List<Game> {
        return api.getSuggestedGames(gameId, Constants.API_KEY).results
    }

    // Funções para acessar o banco de dados local de jogos favoritos
    suspend fun getFavoriteGames(): List<FavoriteGameEntity> = dao.getFavoriteGames()

    suspend fun addToFavorites(game: FavoriteGameEntity) = dao.addToFavorites(game)

    suspend fun removeFromFavorites(game: FavoriteGameEntity) = dao.removeFromFavorites(game)
}



