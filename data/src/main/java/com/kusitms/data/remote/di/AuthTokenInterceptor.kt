package com.kusitms.data.remote.di

import android.util.Log
import com.kusitms.data.local.AuthDataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthTokenInterceptor @Inject constructor(
    private val authDataStore: AuthDataStore,
    private val tokenManager: TokenManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer ${authDataStore.authToken}")
            .build()

        val response = chain.proceed(request)
        // 토큰 만료 감지
        if (response.code == 500) {
            // 토큰 매니저 인스턴스를 가져오고 토큰 갱신을 시도
            runBlocking {
                launch(Dispatchers.IO) {
                    tokenManager.refreshAccessToken()
                }.join() // 갱신 완료 대기
            }
            // 갱신된 토큰으로 요청 재시도
            request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer ${authDataStore.authToken}")
                .build()
            response.close() // 이전 응답 닫기
           return chain.proceed(request)
        }

        return response
    }
}
