package com.kusitms.data.repository

import android.util.Log
import com.kusitms.data.local.AuthDataStore
import com.kusitms.data.remote.api.KusitmsApi
import com.kusitms.data.remote.entity.request.LoginRequestBody
import com.kusitms.data.remote.entity.request.mapToLoginRequestBody
import com.kusitms.domain.model.login.LoginMemberModel
import com.kusitms.domain.repository.LoginRepository
import javax.inject.Inject


class LoginRepositoryImpl @Inject constructor(
    private val kusitmsApi: KusitmsApi,
    private val authDataStore: AuthDataStore
): LoginRepository {
    override suspend fun LoginMember(
        email: String,
        password: String
    ): Result<Unit> {
        return try {
            val model = LoginMemberModel(email,password)
            val request = mapToLoginRequestBody(model)
            val response = kusitmsApi.loginMember(request)
            if (response.result.code == 200 && response.payload != null) {
                Log.d("auth", response.payload.accessToken.toString())

                authDataStore.saveAuthToken(response.payload.accessToken)
                authDataStore.saveRefreshToken(response.payload.refreshToken)
                authDataStore.updateLogin(true)

                Result.success(Unit)
            } else {
                Result.failure(RuntimeException("로그인 실패: ${response.result.message}"))
            }
        } catch (e: Exception){
            Result.failure(e)
        }
    }
}
