package com.example.gamepocket.source.rawg.domain.mapper

import com.example.gamepocket.source.rawg.data.remote.GameDetailResponse
import com.example.gamepocket.source.rawg.data.remote.ScreenshotResponse
import com.example.gamepocket.source.rawg.domain.model.GameImage
import com.example.gamepocket.source.rawg.utils.orIntMin

fun ScreenshotResponse.toDomain(): GameImage {
    return GameImage(
        id = id.orIntMin(),
        imageUrl = image.orEmpty()
    )
}

fun GameDetailResponse.toGameImage(): GameImage {
    return GameImage(id.orIntMin(), backgroundImage.orEmpty())
}