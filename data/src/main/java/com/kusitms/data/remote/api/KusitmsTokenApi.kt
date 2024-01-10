package com.kusitms.data.remote.api

import com.kusitms.data.remote.entity.response.LoginResponse
import retrofit2.http.GET

interface KusitmsTokenApi {
    @GET("v1/auth/reissue")
    suspend fun RefreshAccessToken() : LoginResponse
}