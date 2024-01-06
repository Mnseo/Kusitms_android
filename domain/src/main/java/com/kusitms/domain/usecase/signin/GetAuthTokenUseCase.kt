package com.kusitms.domain.usecase.signin

import com.kusitms.domain.model.login.TokenModel
import com.kusitms.domain.repository.AuthRepository
import javax.inject.Inject

class GetAuthTokenUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): Result<TokenModel?> {
        return authRepository.getAuthToken()
    }
}