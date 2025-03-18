package com.example.gamepocketr.source.rawg.utils

import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.DrawableRes


fun LinearLayout.addPlatformIcons(@DrawableRes vararg icons: Int) {
    icons.forEach { res ->
        addView(ImageView(context).also {
            it.setImageResource(res)
            it.setPadding(0, 0, context.resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._16sdp), 0)
        })
    }
}