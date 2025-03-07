package com.example.gamepocket.core.ui.Home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.gamepocket.core.data.api.RetrofitInstance
import com.example.gamepocket.core.data.database.AppDatabase
import com.example.gamepocket.core.data.repository.GameRepository
import com.example.gamepocket.core.ui.adapter.GameAdapter
import com.example.gamepocket.databinding.FragmentHomeBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels {
        HomeViewModelFactory(GameRepository(RetrofitInstance.api, AppDatabase.getInstance(requireContext()).gameDao()))
    }

    private val adapter = GameAdapter { game ->
        Log.d("GameClick", "Jogo clicado: ${game.name}, ID: ${game.id}")
        findNavController().navigate(
            HomeFragmentDirections.actionHomeToDetail(game.id)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = adapter

        lifecycleScope.launch {
            viewModel.games.collectLatest { games ->
                Log.d("API_TEST", "Total de jogos recebidos: ${games.size}")
                games.forEach {
                    Log.d("API_TEST", "Jogo: ${it.name} - Lançamento: ${it.released}")
                }
                adapter.submitList(games)
            }
        }

        viewModel.loadGames()  // Busca os jogos da API

        // Exemplo: Buscar detalhes de um jogo específico após 5 segundos
        lifecycleScope.launch {
            delay(5000)
            val gameId = 3328 // God of War ID só de exemplo
            viewModel.loadGameDetailForTest(gameId)
        }

        lifecycleScope.launch {
            viewModel.testGameDetail.collectLatest { gameDetail ->
                gameDetail?.let {
                    Log.d("API_TEST", "Detalhes do jogo: ${it.name} - ${it.description}")
                }
            }
        }
    }
}


