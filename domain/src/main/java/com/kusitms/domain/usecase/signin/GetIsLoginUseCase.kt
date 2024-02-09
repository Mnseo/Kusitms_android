package com.kusitms.domain.usecase.signin

import com.kusitms.domain.model.login.TokenModel
import com.kusitms.domain.repository.AuthRepository
import javax.inject.Inject

class GetIsLoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): Result<Boolean?> {
        return authRepository.getIsLogin()
    }
}