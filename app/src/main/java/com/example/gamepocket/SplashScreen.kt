package com.example.gamepocket.core.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.gamepocket.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            delay(7000) // Aguarda 7 segundos (pode ajustar conforme necessário)
            if (isAdded) {
                findNavController().navigate(R.id.action_splashScreen_to_homeFragment)
            }
        }
    }
}
