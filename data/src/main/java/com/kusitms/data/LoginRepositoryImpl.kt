package com.kusitms.data

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

    override suspend fun fetchLoginMemberProfile(): Result<LoginMemberProfile> {
        return try {
            val response = kusitmsApi.LoginMemberProfile()
            if (response.payload == null) {
                Result.failure(RuntimeException("올바른 데이터를 받지 못했습니다."))
            } else {
                val profile = LoginMemberProfile(
                    name = response.payload.name,
                    email = response.payload.email,
                    period = response.payload.period,
                    phoneNumber = response.payload.phoneNumber,
                    memberDetailExist = response.payload.memberDetailExist
                )
                AuthDataStore.isExistProfile = response.payload.memberDetailExist
                AuthDataStore.period= response.payload.period
                Result.success(profile)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }


}
