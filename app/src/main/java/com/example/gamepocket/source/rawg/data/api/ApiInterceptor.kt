package com.example.gamepocket.source.rawg.data.api

import com.example.gamepocket.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url
            .newBuilder()
            .addQueryParameter("key", BuildConfig.API_KEY) // Certifique-se que está maiúsculo
            .build()
        return chain.proceed(request.newBuilder().url(url).build())
    }
}
