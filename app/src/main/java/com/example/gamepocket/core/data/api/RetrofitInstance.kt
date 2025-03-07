package com.example.gamepocket.core.data.api

import com.example.gamepocket.core.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Objeto de instância do Retrofit para a API
object RetrofitInstance {
    // Configuração do Retrofit
    val api: GameApiService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GameApiService::class.java)
    }
}
