package com.kusitms.data.repository

import com.kusitms.data.local.AuthDataStore
import com.kusitms.data.local.DataStoreUtils
import com.kusitms.data.remote.api.KusitmsApi
import com.kusitms.domain.model.login.LoginMemberProfile
import com.kusitms.domain.model.login.TokenModel
import com.kusitms.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataStore: AuthDataStore,
    private val kusitmsApi: KusitmsApi
): AuthRepository {
    override suspend fun getLoginMemberProfile(): Result<LoginMemberProfile?> {
        return try {
            Result.success(authDataStore.loginMemberProfile)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun logOutMember(): Result<Unit> {
        return try {
            val response = kusitmsApi.logOutMember()
            if (response.result.code == 200) {
                DataStoreUtils.clear()
                Result.success(Unit)
            } else {
                Result.failure(RuntimeException("올바른 데이터를 받지 못했습니다."))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun signOutMember(): Result<Unit> {
        return try {
            val response = kusitmsApi.signOutMember()
            if (response.result.code == 200) {
                DataStoreUtils.clear()
                Result.success(Unit)
            } else {
                Result.failure(RuntimeException("올바른 데이터를 받지 못했습니다."))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getAuthToken(): Result<TokenModel?> {
        return try {
            val authToken = authDataStore.authToken
            val refreshToken = authDataStore.refreshToken
            if (!authToken.isNullOrEmpty() && !refreshToken.isNullOrEmpty()) {
                Result.success(TokenModel(authToken, refreshToken))
            } else {
                Result.success(null)
            }
        } catch (e:Exception) {
            Result.failure(e)
        }
    }
}
