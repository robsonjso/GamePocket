package com.example.gamepocket.core.data.api

import com.example.gamepocket.core.data.model.GameResponse
import com.example.gamepocket.core.data.model.GameDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// Interface para definir os endpoints da API
interface GameApiService {

    // Endpoint para obter a lista de jogos
    @GET("games")
    suspend fun getGames(
        @Query("key") apiKey: String,
        @Query("search") search: String? = null,
        @Query("ordering") ordering: String? = null,
        @Query("genres") genres: String? = null
    ): GameResponse

 // Endpoint para obter detalhes de um jogo específico
    @GET("games/{id}")
    suspend fun getGameDetail(
        @Path("id") gameId: Int,
        @Query("key") apiKey: String
    ): GameDetail

 // Endpoint para obter jogos recomendados para um jogo específico
    @GET("games/{id}/suggested")
    suspend fun getSuggestedGames(
        @Path("id") gameId: Int,
        @Query("key") apiKey: String,
    ): GameResponse
}

