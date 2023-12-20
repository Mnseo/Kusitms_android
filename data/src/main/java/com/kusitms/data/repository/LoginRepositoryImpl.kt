package com.kusitms.data.repository

import com.kusitms.data.local.AuthDataStore
import com.kusitms.data.remote.api.KusitmsApi
import com.kusitms.data.remote.entity.response.LoginMemberProfilePayload
import com.kusitms.data.remote.entity.response.LoginMemberProfileResponse
import com.kusitms.domain.model.login.LoginMemberProfile
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
            val response = kusitmsApi.LoginMember(email, password)
            if (response.result.code == 200 && response.payload != null) {
                AuthDataStore.authToken = response.payload.accessToken
                Result.success(Unit)
            } else {
                Result.failure(RuntimeException("로그인 실패: ${response.result.message}"))
            }
        } catch (e: Exception){
            Result.failure(e)
        }
    }

}
