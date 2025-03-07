package com.example.gamepocket.core.ui.detail


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gamepocket.core.data.repository.GameRepository

class DetailViewModelFactory(
    private val repository: GameRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
