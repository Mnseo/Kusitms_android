package com.kusitms.domain.repository

import com.kusitms.domain.model.login.LoginMemberProfile
import com.kusitms.domain.model.signin.SignInRequestModel

interface SignInRepository {
    suspend fun getLoginMemberProfile(): Result<LoginMemberProfile>

    suspend fun signInRequest(email:String, password:String): Result<SignInRequestModel>
}