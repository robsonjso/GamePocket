package com.example.gamepocket.source.rawg.common.platform

import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import com.example.gamepocket.R


enum class PlatformConfig(@DimenRes val size: Int, @DrawableRes val divider: Int) {
    Small(
        size = com.intuit.sdp.R.dimen._16sdp,
        divider = R.drawable.drawable_small_platform_divider
    ),
    Medium(
        size = com.intuit.sdp.R.dimen._16sdp,
        divider = R.drawable.drawable_medium_platform_divider
    ),
}