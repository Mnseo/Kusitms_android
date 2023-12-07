package com.kusitms.data.remote.api

import com.kusitms.domain.entity.BaseResponse
import com.kusitms.domain.entity.request.LogInRequest
import com.kusitms.domain.entity.response.LogInResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface KusitmsApi {
    @GET("auth/login/MEMBER")
    suspend fun LogInMember(@Body request:LogInRequest): LogInResponse

}