package com.example.gamepocket.core.data.model

import com.google.gson.annotations.SerializedName

 // Modelo de dados para a lista de jogos
data class GameDetail(
    // Adicione os campos que você precisa aqui para a tela de detalhes do jogo
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description_raw")
    val description: String,
    @SerializedName("background_image")
    val backgroundImage: String?,
    @SerializedName("released")
    val released: String?,
    @SerializedName("rating")
    val rating: Float
)


