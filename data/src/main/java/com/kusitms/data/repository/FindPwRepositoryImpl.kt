package com.kusitms.data.repository

import com.kusitms.data.remote.api.KusitmsApi
import com.kusitms.domain.repository.FindPwRepository
import javax.inject.Inject

class FindPwRepositoryImpl@Inject constructor(
    private val kusitmsApi: KusitmsApi
): FindPwRepository {

    override suspend fun FindPwEmailCheck(
        email: String
    ): Result<Unit> {
        return try {
            val response = kusitmsApi.VerifyEmailCheck(email)
            if (response.result.code == 200) {
                Result.success(Unit)
            } else {
                Result.failure(RuntimeException("로그인 실패: ${response.result.message}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun FindPwVerifyCode(
        email: String,
        code: String
    ): Result<Unit> {
        TODO("Not yet implemented")
    }
}