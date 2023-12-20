package com.kusitms.data.remote.di

import android.util.Log
import com.kusitms.data.local.AuthDataStore
import okhttp3.Interceptor
import okhttp3.Response

class AuthTokenInterceptor(private val authDataStore: AuthDataStore) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val isTokenRefreshRequest = originalRequest.url.encodedPath.endsWith("auth/reissue")

        val modifiedRequest = originalRequest.newBuilder()
            .apply {
                addHeader("Authorization", "Bearer ${authDataStore.authToken}")
                if (isTokenRefreshRequest) {
                    addHeader("Refresh-Token", authDataStore.refreshToken)
                }
            }
            .build()
        return chain.proceed(modifiedRequest)
    }
}
