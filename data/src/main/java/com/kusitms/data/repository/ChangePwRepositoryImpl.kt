package com.kusitms.data.repository

import com.kusitms.data.remote.api.KusitmsApi
import com.kusitms.data.remote.entity.response.toModel
import com.kusitms.domain.repository.ChangePwRepository
import javax.inject.Inject

class ChangePwRepositoryImpl@Inject constructor(
    private val kusitmsApi: KusitmsApi
): ChangePwRepository {

    override suspend fun checkPassword(password : String): Result<Boolean> {
        return try {
            val response = kusitmsApi.checkPassword(password)
            if (response.result.code == 200 && response.payload != null) {
                Result.success(response.payload.isCorrect)
            } else {
                Result.failure(RuntimeException("이메일 확인 실패: ${response.result.message}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}