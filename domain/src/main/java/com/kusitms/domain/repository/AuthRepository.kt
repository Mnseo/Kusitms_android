package com.kusitms.domain.repository


import com.kusitms.domain.model.login.LoginMemberProfile
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun getLoginMemberProfile() : Result<LoginMemberProfile?>

    suspend fun logOutMember(): Result<Unit>

    suspend fun signOutMember(): Result<Unit>
}