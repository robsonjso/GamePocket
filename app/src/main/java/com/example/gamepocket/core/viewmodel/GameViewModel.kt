package com.example.gamepocket.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamepocket.core.data.model.Game
import com.example.gamepocket.core.data.repository.GameRepository
import com.example.gamepocket.core.data.model.GameDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// ViewModel para a tela de jogos
class GameViewModel(private val repository: GameRepository) : ViewModel() {

    // Estados para os detalhes do jogo e jogos recomendados
    private val _games = MutableStateFlow<List<Game>>(emptyList())
    val games = _games.asStateFlow()

    // Estados para os detalhes do jogo e jogos recomendados
    private val _gameDetail = MutableStateFlow<GameDetail?>(null)
    val gameDetail = _gameDetail.asStateFlow()

    // Lista de jogos recomendados
    private val _suggestedGames = MutableStateFlow<List<Game>>(emptyList())
    val suggestedGames = _suggestedGames.asStateFlow()

    // Carrega a lista de jogos
    fun fetchGames(search: String? = null, ordering: String? = null, genres: String? = null) {
        viewModelScope.launch {
            val result = repository.getGames(search, ordering, genres)
            _games.value = result
        }
    }
    // Carrega os detalhes do jogo e os jogos recomendados
    fun fetchGameDetail(gameId: Int) {
        viewModelScope.launch {
            _gameDetail.value = repository.getGameDetail(gameId)
            _suggestedGames.value = repository.getSuggestedGames(gameId)
        }
    }
}

