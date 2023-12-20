package com.kusitms.data.remote.api

import com.kusitms.data.remote.entity.response.LoginMemberProfileResponse
import com.kusitms.data.remote.entity.response.LoginResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface KusitmsApi {

    @GET("auth/login/MEMBER")
    suspend fun LoginMember(
        @Query("email") email:String,
        @Query("password") password: String
    ): LoginResponse

    @GET("member/info")
    suspend fun LoginMemberProfile(): LoginMemberProfileResponse

}