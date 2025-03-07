package com.example.gamepocket.core.util

import android.content.Context
import android.net.ConnectivityManager

// Classe de utilitários para verificar a disponibilidade de rede
object NetworkUtils {
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}
