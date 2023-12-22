package com.kusitms.data.remote.di

import com.kusitms.data.local.AuthDataStore
import com.kusitms.data.remote.api.KusitmsApi

class TokenManager(
    private val kusitmsApi: KusitmsApi,
    private val authDataStore: AuthDataStore
) {
    suspend fun refreshAccessToken(): Boolean {
        return try {
            val response = kusitmsApi.RefreshAccessToken()
            if (response.result.code == 200 && response.payload != null) {
                authDataStore.authToken = response.payload.accessToken
                authDataStore.refreshToken = response.payload.refreshToken
                true
            } else {
                false
            }

        } catch (e: Exception) {
            false
        }
    }
}
