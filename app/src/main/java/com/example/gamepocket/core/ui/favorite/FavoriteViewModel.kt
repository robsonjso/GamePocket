package com.example.gamepocket.core.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamepocket.core.data.database.FavoriteGameEntity
import com.example.gamepocket.core.data.repository.GameRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// ViewModel para a tela de favoritos
class FavoriteViewModel(private val repository: GameRepository) : ViewModel() {

    // Estado para a lista de jogos favoritos
    private val _favorites = MutableStateFlow<List<FavoriteGameEntity>>(emptyList())
    val favorites = _favorites.asStateFlow()

    // Carrega a lista de jogos favoritos
    fun loadFavorites() {
        viewModelScope.launch {
            _favorites.value = repository.getFavoriteGames()
        }
    }
}
