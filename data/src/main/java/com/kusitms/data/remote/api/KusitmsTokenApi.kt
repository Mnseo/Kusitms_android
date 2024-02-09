package com.kusitms.data.remote.api

import com.kusitms.data.remote.entity.BaseResponse
import com.kusitms.data.remote.entity.response.LoginResponse
import com.kusitms.domain.model.login.TokenModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface KusitmsTokenApi {
    @GET("v1/auth/reissue")
    suspend fun RefreshAccessToken(@Header("RefreshToken") refreshToken: String) : LoginResponse

}