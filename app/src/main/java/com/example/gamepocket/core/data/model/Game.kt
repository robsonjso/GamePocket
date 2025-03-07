package com.example.gamepocket.core.data.model

import com.google.gson.annotations.SerializedName
 // Modelo de dados para um jogo
data class Game(
     // Adicione os campos que você precisa aqui
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("released")
    val released: String?,
    @SerializedName("background_image")
    val backgroundImage: String?,
    @SerializedName("rating")
    val rating: Float,
)
