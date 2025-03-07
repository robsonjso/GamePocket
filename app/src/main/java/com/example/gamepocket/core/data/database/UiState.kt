package com.example.gamepocket.core.data.database

// Classe para representar o estado da UI
sealed class UiState<out T> {
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
    object Loading : UiState<Nothing>()
}
