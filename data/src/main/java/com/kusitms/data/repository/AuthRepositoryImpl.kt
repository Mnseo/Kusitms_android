package com.kusitms.data.repository

import android.content.Context
import android.net.ConnectivityManager
import com.kusitms.data.local.AuthDataStore
import com.kusitms.data.local.DataStoreUtils
import com.kusitms.data.remote.api.KusitmsApi
import com.kusitms.data.remote.api.KusitmsTokenApi
import com.kusitms.domain.model.login.LoginMemberProfile
import com.kusitms.domain.model.login.TokenModel
import com.kusitms.domain.repository.AuthRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class AuthRepositoryImpl @Inject constructor(
    private val authDataStore: AuthDataStore,
    private val kusitmsApi: KusitmsApi,
    @ApplicationContext private val context: Context
): AuthRepository {
    override suspend fun getLoginMemberProfile(): Result<LoginMemberProfile?> {
        return try {
            val profile = authDataStore.loginMemberProfile.first()
            Result.success(profile)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getIsLogin() :Result<Boolean?> {
        return try {
            val login = authDataStore.isLogin.first()
            Result.success(login)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun logOutMember(): Result<Unit> {
        return try {
            val response = kusitmsApi.logOutMember()
            if (response.result.code == 200) {
                authDataStore.clearAllData()
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
                authDataStore.clearAllData()
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
            val authToken = authDataStore.authToken.first()
            val refreshToken = authDataStore.refreshToken.first()
            if (!authToken.isNullOrEmpty() && !refreshToken.isNullOrEmpty()) {
                Result.success(TokenModel(authToken, refreshToken))
            } else {
                Result.success(null)
            }
        } catch (e:Exception) {
            Result.failure(e)
        }
    }

    override fun checkInternetConnection(): Boolean {
        val connectivity = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivity.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }

}
