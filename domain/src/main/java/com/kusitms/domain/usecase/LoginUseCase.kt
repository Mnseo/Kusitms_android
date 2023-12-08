package com.kusitms.domain.usecase

import com.kusitms.domain.entity.ApiResult
import com.kusitms.domain.entity.request.LoginRequest
import com.kusitms.domain.entity.response.LoginResponse
import com.kusitms.domain.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ): ApiResult<LoginResponse> {
        return try {
            val response = loginRepository.LoginMember(email,password)
            ApiResult.Success(response)
        } catch (e: Throwable) {
            ApiResult.Failure(e)
        }
    }
}
