package com.example.gamepocket.core.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamepocket.core.data.model.Game
import com.example.gamepocket.core.data.repository.GameRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// ViewModel para a tela de jogos
class SearchViewModel(private val repository: GameRepository) : ViewModel() {

    // Estado para a lista de jogos
    private val _searchResults = MutableStateFlow<List<Game>>(emptyList())
    val searchResults = _searchResults.asStateFlow()

    // Carrega a lista de jogos
    fun searchGames(query: String) {
        viewModelScope.launch {
            _searchResults.value = repository.getGames(search = query, ordering = null, genres = null)
        }
    }
}
