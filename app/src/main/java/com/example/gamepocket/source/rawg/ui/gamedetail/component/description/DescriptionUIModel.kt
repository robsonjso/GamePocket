package com.example.gamepocket.source.rawg.ui.gamedetail.component.description

import com.example.gamepocket.source.rawg.ui.gamedetail.component.Component
import com.example.gamepocket.source.rawg.ui.gamedetail.component.ViewType

class DescriptionUIModel(val description: String) : Component {
    override val type: ViewType
        get() = ViewType.DESCRIPTION_VIEW_TYPE
}