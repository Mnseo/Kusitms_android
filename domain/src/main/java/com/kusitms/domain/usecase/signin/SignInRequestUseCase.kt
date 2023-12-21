package com.kusitms.domain.usecase.signin

import com.kusitms.domain.model.signin.SignInRequestModel
import com.kusitms.domain.repository.SignInRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignInRequestUseCase @Inject constructor(
    private val signInRepository: SignInRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ): Result<SignInRequestModel> {
        return signInRepository.signInRequest(email, password)
    }
}
