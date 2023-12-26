package com.kusitms.data.repository

import com.kusitms.data.remote.api.KusitmsApi
import com.kusitms.data.remote.entity.request.UpdatePasswordRequest
import com.kusitms.data.remote.entity.response.notice.toModel
import com.kusitms.data.remote.entity.response.toModel
import com.kusitms.domain.model.findpw.FindPwCheckEmailModel
import com.kusitms.domain.model.findpw.FindPwCodeVerifyModel
import com.kusitms.domain.repository.FindPwRepository
import javax.inject.Inject

class FindPwRepositoryImpl@Inject constructor(
    private val kusitmsApi: KusitmsApi
): FindPwRepository {

    override suspend fun FindPwEmailCheck(
        email: String
    ): Result<FindPwCheckEmailModel> {
        return try {
            val response = kusitmsApi.verifyEmailCheck(email)
            if (response.result.code == 200 && response.payload != null) {
                Result.success(response.payload.toModel())
            } else {
                Result.failure(RuntimeException("이메일 확인 실패: ${response.result.message}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun SendCode(email: String): Result<Unit> {
        return try {
            val response = kusitmsApi.sendCode(email)
            if(response.result.code == 200) {
                Result.success(Unit)
            } else {
                Result.failure(RuntimeException("이메일 확인 실패: ${response.result.message}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun VerifyCode(email: String, code: String): Result<FindPwCodeVerifyModel> {
        return  try {
            val response = kusitmsApi.verifyCode(email,code)
            if(response.result.code == 200) {
                Result.success(response.payload.toModel())
            } else {
                Result.failure(RuntimeException("코드 검증 실패: ${response.result.message}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun UpdatePassword(
        email: String,
        password:String
    ): Result<Unit> {
        return try {
            val response = kusitmsApi.updatePassword(
                email,
                UpdatePasswordRequest(password)
            )
            if (response.result.code == 200) {
                Result.success(Unit)
            } else {
                Result.failure(RuntimeException("비밀번호 업데이트 실패: ${response.result.message}"))
            }
        }  catch (e: Exception) {
        Result.failure(e)
        }
    }


}