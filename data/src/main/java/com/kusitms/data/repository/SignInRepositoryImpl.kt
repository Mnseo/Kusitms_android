package com.kusitms.data.repository

import com.kusitms.data.local.AuthDataStore
import com.kusitms.data.remote.api.KusitmsApi
import com.kusitms.domain.model.login.LoginMemberProfile
import com.kusitms.domain.repository.SignInRepository
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(
    private val kusitmsApi: KusitmsApi
): SignInRepository {
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