package com.kusitms.data.remote.api

import com.kusitms.domain.entity.request.LoginRequest
import com.kusitms.domain.entity.response.LogInResponse
import retrofit2.http.Body
import retrofit2.http.GET


interface KusitmsApi {
    @GET("auth/login/MEMBER")
    suspend fun LogInMember(@Body request:LoginRequest): LogInResponse

}