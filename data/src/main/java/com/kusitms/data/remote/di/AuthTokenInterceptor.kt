package com.kusitms.data.remote.di


import android.util.Log
import com.kusitms.data.local.AuthDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.*
import timber.log.Timber
import javax.inject.Inject

class AuthTokenInterceptor @Inject constructor(
    private val authDataStore: AuthDataStore,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()

         val token: String? = runBlocking {
             authDataStore.authToken.first()
         } ?: ""

        val refresh: String? = runBlocking {
            authDataStore.refreshToken.first()
        }?: ""

        // "auth/logout" 엔드포인트 확인
        if (!token.isNullOrEmpty()) {
            requestBuilder.addHeader("Authorization", "$token")
        }

        // 로그아웃 요청에는 리프레시 토큰도 추가
        if (originalRequest.url.encodedPath.endsWith("v1/auth/logout")) {
            val refreshToken: String? = runBlocking {
                authDataStore.refreshToken.first()
            }
            if (!refreshToken.isNullOrEmpty()) {
                requestBuilder.addHeader("RefreshToken", "$refresh")
            }
        }

        var request = requestBuilder.build()
        var response = chain.proceed(request)

        if (response.code == 200) {
            val newAccessToken: String = response.header("Authorization", null) ?: return response
            Timber.d("new Access Token = ${newAccessToken}")

            CoroutineScope(Dispatchers.IO).launch {
                val existedAccessToken = authDataStore.authToken.first()
                if (existedAccessToken != newAccessToken) {
                    authDataStore.saveAuthToken(newAccessToken)
                    Timber.d("newAccessToken = ${newAccessToken}\nExistedAccessToken = ${existedAccessToken}")
                }
            }
        } else {
            Timber.e("${response.code} : ${response.request} \n ${response.message}")
        }


        return response
    }

    private fun errorResponse(request: Request): Response = Response.Builder()
        .request(request)
        .protocol(Protocol.HTTP_2)
        .message("")
        .code(401)
        .body(ResponseBody.create(null, ""))
        .build()
}

