package com.kusitms.data.remote.api

import com.kusitms.data.remote.entity.response.LoginMemberProfileResponse
import com.kusitms.data.remote.entity.response.LoginResponse
import com.kusitms.data.remote.entity.response.SignInRequestResponse
import retrofit2.http.*


interface KusitmsApi {

    @GET("auth/login/MEMBER")
    suspend fun LoginMember(
        @Query("email") email:String,
        @Query("password") password: String
    ): LoginResponse

    @GET("auth/reissue")
    suspend fun RefreshAccessToken() : LoginResponse

    @GET("member/info")
    suspend fun LoginMemberProfile(): LoginMemberProfileResponse

    @FormUrlEncoded
    @POST("member/check/register")
    suspend fun SignInRequestCheck(
        @Field("email") email: String,
        @Field("password") password: String
    ): SignInRequestResponse

    @FormUrlEncoded
    @POST("member/register")
    suspend fun SignInRequest(
        @Field("email") email: String,
        @Field("password") password: String
    ): SignInRequestResponse

}