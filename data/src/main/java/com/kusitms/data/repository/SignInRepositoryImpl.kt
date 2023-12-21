package com.kusitms.data.repository

import com.kusitms.data.local.AuthDataStore
import com.kusitms.data.remote.api.KusitmsApi
import com.kusitms.data.remote.entity.response.toModel
import com.kusitms.domain.model.login.LoginMemberProfile
import com.kusitms.domain.model.signin.SignInRequestModel
import com.kusitms.domain.repository.SignInRepository
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(
    private val kusitmsApi: KusitmsApi
): SignInRepository {
    override suspend fun getLoginMemberProfile(): Result<LoginMemberProfile> {
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
                AuthDataStore.loginMemberProfile = profile
                Result.success(profile)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun signInRequest(
        email: String,
        password: String
    ): Result<SignInRequestModel> {
        return try {
            val response = kusitmsApi.SignInRequest(email, password)
            if(response.payload == null) {
                Result.failure(RuntimeException("올바른 데이터를 받지 못했습니다."))
            } else {
                Result.success(response.payload.toModel())
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}