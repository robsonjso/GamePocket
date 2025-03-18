package com.example.gamepocket.source.rawg.domain.mapper


import com.example.gamepocket.source.rawg.data.remote.GameListItemResponse
import com.example.gamepocket.source.rawg.domain.model.GameListItem
import com.example.gamepocket.source.rawg.utils.orIntMin
import com.synthesizer.source.rawg.common.platform.PlatformUIModel

fun GameListItemResponse.toDomain(): GameListItem {
    return GameListItem(
        id = id.orIntMin(),
        name = name.orEmpty(),
        imageUrl = backgroundImage.orEmpty(),
        platformUIModel = PlatformUIModel(
            parentPlatforms.orEmpty().mapNotNull { it.platform?.slug })
    )
}