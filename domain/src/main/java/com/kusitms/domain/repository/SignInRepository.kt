package com.kusitms.domain.repository

import com.kusitms.domain.model.login.LoginMemberProfile
import com.kusitms.domain.model.signin.SignInRequestCheckModel

interface SignInRepository {
    suspend fun getLoginMemberProfile(): Result<LoginMemberProfile>

    suspend fun signInRequestCheck(email:String, password:String): Result<SignInRequestCheckModel>

    suspend fun signInRequest(email: String, password: String): Result<Unit>
}