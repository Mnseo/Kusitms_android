package com.kusitms.domain.usecase


import com.kusitms.domain.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ): ApiResult<Unit> { // 단순히 성공/실패 여부만 반환
        return try {
            val response = loginRepository.loginMember(email, password)
            if (response.payload == null) {
                ApiResult.ApiError(200, "올바른 데이터를 받지 못했습니다.")
            } else {
                // 성공 시 토큰은 DataStore에 저장하고 성공만 반환
                // 예를 들어, response.payload.accessToken을 DataStore에 저장
                AuthDataStore.authToken = response.payload.accessToken
                ApiResult.Success(Unit) // 성공 시 Unit 반환
            }
        } catch(e: Throwable) {
            ApiResult.Failure(e)
        }
    }
}
