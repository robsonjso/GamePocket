package com.example.gamepocket.source.rawg.core.domain.model

data class Error(
    val throwable: Throwable,
    val callback: () -> Unit = {},
)

data class AppError(
    val throwable: Throwable,
    val callback: () -> Unit = {},
)