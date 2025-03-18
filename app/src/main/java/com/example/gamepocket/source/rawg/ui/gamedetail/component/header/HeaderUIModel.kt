package com.example.gamepocket.source.rawg.ui.gamedetail.component.header

import com.example.gamepocket.source.rawg.ui.gamedetail.component.Component
import com.example.gamepocket.source.rawg.ui.gamedetail.component.ViewType

class HeaderUIModel(val image: String) : Component {
    override val type: ViewType
        get() = ViewType.HEADER_VIEW_TYPE
}