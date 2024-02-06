package com.kusitms.data.repository

import com.kusitms.data.remote.api.KusitmsApi
import com.kusitms.data.remote.entity.request.UpdatePasswordRequest
import com.kusitms.data.remote.entity.request.mapToPasswordRequestBody
import com.kusitms.domain.model.login.LoginPasswordModel
import com.kusitms.domain.repository.ChangePwRepository
import javax.inject.Inject

class ChangePwRepositoryImpl@Inject constructor(
    private val kusitmsApi: KusitmsApi
): ChangePwRepository {

    override suspend fun checkPassword(password: String): Result<Boolean> {
        return try {
            val model = LoginPasswordModel(password)
            val request = mapToPasswordRequestBody(model)
            val response = kusitmsApi.checkPassword(request)
            if (response.result.code == 200 && response.payload != null) {
                Result.success(response.payload.isCorrect)
            } else {
                Result.failure(RuntimeException("이메일 확인 실패: ${response.result.message}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun updatePasswordAsLoggedIn(password: String): Result<Unit> {
        return try {
            val response = kusitmsApi.updatePasswordAsLoggedIn(UpdatePasswordRequest(password))
            if (response.result.code == 200 && response.payload != null) {
                Result.success(Unit)
            } else {
                Result.failure(RuntimeException("이메일 확인 실패: ${response.result.message}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}