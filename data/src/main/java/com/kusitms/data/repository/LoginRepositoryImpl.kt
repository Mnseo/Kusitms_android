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
    private val kusitmsApi: KusitmsApi
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
                AuthDataStore().authToken = response.payload.accessToken
                AuthDataStore().refreshToken = response.payload.refreshToken
                Result.success(Unit)
            } else {
                Result.failure(RuntimeException("로그인 실패: ${response.result.message}"))
            }
        } catch (e: Exception){
            Result.failure(e)
        }
    }
}
