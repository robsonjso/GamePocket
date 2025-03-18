package com.example.gamepocket.source.rawg.domain.model

import com.example.gamepocket.source.rawg.domain.model.GameImage
import com.example.gamepocket.source.rawg.domain.model.GameDetailInfo

data class GameDetail(val info: GameDetailInfo, val screenshots: List<GameImage>)