package com.example.gamepocket.core.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamepocket.core.data.model.Game
import com.example.gamepocket.core.data.model.GameDetail
import com.example.gamepocket.core.data.repository.GameRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// ViewModel para a tela de detalhes do jogo
class DetailViewModel(private val repository: GameRepository) : ViewModel() {

    // Estados para os detalhes do jogo e jogos recomendados
    private val _gameDetail = MutableStateFlow<GameDetail?>(null)
    val gameDetail = _gameDetail.asStateFlow()

    // Lista de jogos recomendados
    private val _suggestedGames = MutableStateFlow<List<Game>>(emptyList())
    val suggestedGames = _suggestedGames.asStateFlow()

    // Carrega os detalhes do jogo e os jogos recomendados
    fun loadGameDetails(gameId: Int) {
        viewModelScope.launch {
            _gameDetail.value = repository.getGameDetail(gameId)
            _suggestedGames.value = repository.getSuggestedGames(gameId)
        }
    }
}
