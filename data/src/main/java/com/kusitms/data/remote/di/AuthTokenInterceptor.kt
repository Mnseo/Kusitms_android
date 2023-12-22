package com.kusitms.data.remote.di

import android.util.Log
import com.kusitms.data.local.AuthDataStore
import okhttp3.Interceptor
import okhttp3.Response

class AuthTokenInterceptor(private val authDataStore: AuthDataStore) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val isTokenRefreshRequest = originalRequest.url.encodedPath.endsWith("auth/reissue")
        val isRegister = originalRequest.url.encodedPath.endsWith("member/check/register")

        val modifiedRequest = originalRequest.newBuilder()
            .apply {
                if (isTokenRefreshRequest) {
                    addHeader("Refresh-Token", authDataStore.refreshToken)
                } else if (!isRegister) {
                    // 일반 요청의 경우 Authorization 헤더 추가
                    addHeader("Authorization", "Bearer ${authDataStore.authToken}")
                }
            }
            .build()
        return chain.proceed(modifiedRequest)
    }
}
