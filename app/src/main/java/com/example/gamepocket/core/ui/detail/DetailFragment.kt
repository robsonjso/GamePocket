package com.example.gamepocket.core.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.gamepocket.core.data.api.RetrofitInstance
import com.example.gamepocket.core.data.database.AppDatabase
import com.example.gamepocket.core.data.repository.GameRepository
import com.example.gamepocket.databinding.FragmentDetailBinding
import kotlinx.coroutines.launch

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    private val viewModel: DetailViewModel by viewModels {
        DetailViewModelFactory(GameRepository(RetrofitInstance.api, AppDatabase.getInstance(requireContext()).gameDao()))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadGameDetails(args.gameId)

        lifecycleScope.launch {
            viewModel.gameDetail.collect { detail ->
                detail?.let { game ->
                    binding.gameTitle.text = game.name
                    binding.gameDescription.text = game.description
                    Glide.with(this@DetailFragment).load(game.backgroundImage).into(binding.gameImage)
                }
            }
        }
    }
}
