package com.example.gamepocket.core.ui.Home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamepocket.core.data.model.Game
import com.example.gamepocket.core.data.model.GameDetail
import com.example.gamepocket.core.data.repository.GameRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// ViewModel para a tela de jogos
class HomeViewModel(private val repository: GameRepository) : ViewModel() {
    private val _games = MutableStateFlow<List<Game>>(emptyList())
    val games = _games.asStateFlow()

    // Carrega a lista de jogos
    fun loadGames() {
        viewModelScope.launch {
            val featured = repository.getGames(ordering = "-added", search = null, genres = null)
            _games.value = featured
        }
    }
    private val _testGameDetail = MutableStateFlow<GameDetail?>(null)
    val testGameDetail = _testGameDetail.asStateFlow()

    fun loadGameDetailForTest(gameId: Int) {
        viewModelScope.launch {
            try {
                _testGameDetail.value = repository.getGameDetail(gameId)
                Log.d("API_TEST", "Detalhes carregados com sucesso.")
            } catch (e: Exception) {
                Log.e("API_TEST", "Erro ao buscar detalhes: ${e.message}", e)
            }
        }
    }

}
