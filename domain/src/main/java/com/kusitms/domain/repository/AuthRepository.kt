package com.kusitms.domain.repository


import com.kusitms.domain.model.login.LoginMemberProfile
import com.kusitms.domain.model.login.TokenModel
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun getLoginMemberProfile() : Result<LoginMemberProfile?>

    suspend fun logOutMember(): Result<Unit>

    suspend fun signOutMember(): Result<Unit>

    suspend fun getAuthToken() :Result<TokenModel?>

    fun checkInternetConnection(): Boolean

    suspend fun getIsLogin(): Result<Boolean?>
}