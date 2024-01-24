package com.openinapp.domain.misc

import android.content.Context
import android.util.Log
import com.openinapp.utils.Constants
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newAccessToken = SharedPreferencesUtil(context).get<String>(Constants.TOKEN)
        val newRequest = originalRequest.newBuilder()
            .header("Authorization", "$newAccessToken")
            .build()
        return chain.proceed(newRequest)
    }
}