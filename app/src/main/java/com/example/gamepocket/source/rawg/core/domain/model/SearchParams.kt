package com.example.gamepocket.source.rawg.core.domain.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
class SearchParams(
    val search: String,
    val ordering: String,
    val dates: String
) : Parcelable