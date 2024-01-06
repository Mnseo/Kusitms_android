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
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()

        // "auth/logout" 엔드포인트 확인
        if (originalRequest.url.encodedPath.endsWith("auth/logout")) {
            // logout 엔드포인트의 경우 refreshToken 사용
            requestBuilder.addHeader("Authorization", "${authDataStore.refreshToken}")
        } else {
            // 다른 엔드포인트의 경우 authToken 사용
            requestBuilder.addHeader("Authorization", "${authDataStore.authToken}")
        }

        var request = requestBuilder.build()
        var response = chain.proceed(request)

        // 토큰 만료 감지 및 처리
        if (response.code == 500 && response.code == 401) {
            // 토큰 매니저 인스턴스를 가져오고 토큰 갱신을 시도
            runBlocking {
                launch(Dispatchers.IO) {
                    tokenManager.refreshAccessToken()
                }.join() // 갱신 완료 대기
            }
            // 갱신된 토큰으로 요청 재시도
            request = chain.request().newBuilder()
                .addHeader("Authorization", "${authDataStore.authToken}")
                .build()
            response.close() // 이전 응답 닫기
            return chain.proceed(request)
        }

        return response
    }
}
