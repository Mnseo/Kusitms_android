package com.kusitms.domain.repository

import com.kusitms.domain.model.SignInProfile
import com.kusitms.domain.model.login.LoginMemberProfile
import com.kusitms.domain.model.signin.SignInRequestCheckModel
import java.io.File

interface SignInRepository {
    suspend fun getLoginMemberProfile(): Result<LoginMemberProfile>

    suspend fun signInRequestCheck(email:String, password:String): Result<SignInRequestCheckModel>

    suspend fun signInRequest(email: String, password: String): Result<Unit>

    suspend fun postAdditionalProfile(dto: SignInProfile, file: File): Result<Unit>
}