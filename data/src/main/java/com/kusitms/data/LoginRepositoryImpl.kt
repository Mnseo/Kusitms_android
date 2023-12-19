package com.kusitms.data

import com.kusitms.data.local.AuthDataStore
import com.kusitms.data.remote.api.KusitmsApi
import com.kusitms.domain.repository.LoginRepository
import javax.inject.Inject


class LoginRepositoryImpl @Inject constructor(
    private val kusitmsApi: KusitmsApi
): LoginRepository {
    override suspend fun LoginMember(
        email: String,
        password: String
    ): Result<Unit> {
        // 받고 API 성공/실패 처리 ApiResult<Unit> + Access Token Data store 저장
        // try catch -> body
        return try {
            val response = kusitmsApi.LoginMember(email, password)
            if (response.payload == null) {
                Result.failure(RuntimeException("올바른 데이터를 받지 못했습니다."))
                //ApiResult.ApiError(200, "올바른 데이터를 받지 못했습니다.")
            } else {
                // 성공 시 토큰은 DataStore에 저장하고 성공만 반환
                // 예를 들어, response.payload.accessToken을 DataStore에 저장

                //TODO init 해야할듯?
               // AuthDataStore.authToken = response.payload.accessToken
                Result.success(Unit)
//                ApiResult.Success(Unit) // 성공 시 Unit 반환
            }
        } catch (e: Exception){
            Result.failure(e)
        }

    }
}
