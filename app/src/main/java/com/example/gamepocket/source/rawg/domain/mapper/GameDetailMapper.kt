package com.example.gamepocket.source.rawg.domain.mapper

import com.example.gamepocket.source.rawg.data.remote.GameDetailResponse
import com.example.gamepocket.source.rawg.domain.model.GameDetail
import com.example.gamepocket.source.rawg.domain.model.GameDetailInfo
import com.example.gamepocket.source.rawg.ui.gamedetail.component.Component
import com.example.gamepocket.source.rawg.ui.gamedetail.component.description.DescriptionUIModel
import com.example.gamepocket.source.rawg.ui.gamedetail.component.header.HeaderUIModel
import com.example.gamepocket.source.rawg.ui.gamedetail.component.screenshot.ScreenshotUIModel
import com.example.gamepocket.source.rawg.ui.gamedetail.component.summary.SummaryUIModel
import com.example.gamepocket.source.rawg.utils.convertToDate
import com.example.gamepocket.source.rawg.utils.orIntMin
import com.example.gamepocket.source.rawg.utils.orZero



fun GameDetailResponse.toDomain(): GameDetailInfo {
    return GameDetailInfo(
        id = id.orIntMin(),
        name = name.orEmpty(),
        backgroundImage = backgroundImage.orEmpty(),
        releaseDate = released.orEmpty().convertToDate(),
        publisher = (if (!publishers.isNullOrEmpty()) publishers[0].name else developers.orEmpty()
            .getOrNull(0)?.name).orEmpty(),
        rating = rating.orZero().toFloat(),
        metascore = metacritic.orZero(),
        genres = genres.orEmpty().mapNotNull { it.name }.sortedBy { it.length },
        description = descriptionRaw.orEmpty(),
        platforms = parentPlatforms.orEmpty().mapNotNull { it.platform }.mapNotNull { it.slug }
    )
}

fun GameDetail.toComponents(): List<Component> {
    return listOf(
        HeaderUIModel(
            image = info.backgroundImage
        ),
        SummaryUIModel(
            gameName = info.name,
            releaseDate = info.releaseDate,
            publisherName = info.publisher,
            rating = info.rating,
            platforms = info.platforms,
            metascore = info.metascore,
            genres = info.genres
        ),
        DescriptionUIModel(
            description = info.description
        ),
        ScreenshotUIModel(
            screenshots = screenshots
        )
    )
}