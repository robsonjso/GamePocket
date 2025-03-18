package com.example.gamepocket.source.rawg.data.remote

import com.google.gson.annotations.SerializedName

class ShortScreenshotResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String
)