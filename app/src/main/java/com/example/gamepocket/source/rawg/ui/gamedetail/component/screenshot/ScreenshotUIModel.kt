package com.example.gamepocket.source.rawg.ui.gamedetail.component.screenshot

import com.example.gamepocket.source.rawg.domain.model.GameImage
import com.example.gamepocket.source.rawg.ui.gamedetail.component.Component
import com.example.gamepocket.source.rawg.ui.gamedetail.component.ViewType

class ScreenshotUIModel(val screenshots: List<GameImage>) : Component {
    override val type: ViewType
        get() = ViewType.SCREENSHOT_VIEW_TYPE

}