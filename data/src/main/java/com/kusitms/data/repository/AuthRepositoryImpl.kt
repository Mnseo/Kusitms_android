package com.kusitms.data.repository

import com.kusitms.data.local.AuthDataStore
import com.kusitms.domain.model.login.LoginMemberProfile
import com.kusitms.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataStore: AuthDataStore
): AuthRepository {
    override suspend fun getLoginMemberProfile(): Result<LoginMemberProfile?> {
        return try {
            Result.success(authDataStore.loginMemberProfile)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
