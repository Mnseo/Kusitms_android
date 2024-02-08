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

        // "auth/logout" 엔드포인트 확인
        if (originalRequest.url.encodedPath.endsWith("auth/logout")) {
            // logout 엔드포인트의 경우 refreshToken 사용
            requestBuilder.addHeader("Authorization", "${authDataStore.refreshToken}")
        } else if(originalRequest.url.encodedPath.endsWith("auth/logout"))
        else {
            // 다른 엔드포인트의 경우 authToken 사용
            requestBuilder.addHeader("Authorization", "$token")
        }

        Log.d("Token is","${authDataStore.authToken}")
        Log.d("Token is","${authDataStore.refreshToken}")
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

