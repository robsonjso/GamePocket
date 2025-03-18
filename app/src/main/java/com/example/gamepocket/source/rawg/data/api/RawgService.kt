package com.example.gamepocket.source.rawg.data.api


import com.example.gamepocket.source.rawg.data.remote.GameDetailResponse
import com.example.gamepocket.source.rawg.data.remote.GameListResponse
import com.example.gamepocket.source.rawg.data.remote.GameScreenshotResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RawgService {
    @GET("games")
    suspend fun getGames(
        @Query("page") page: Int,
        @Query("search") search: String,
        @Query("ordering") ordering: String,
        @Query("dates") dates: String
    ): GameListResponse

    @GET("games/{id}")
    suspend fun getGameDetailById(@Path("id") id: Int): Response<GameDetailResponse>

    @GET("games/{id}/screenshots")
    suspend fun getGameScreenshots(@Path("id") id: Int): Response<GameScreenshotResponse>
}