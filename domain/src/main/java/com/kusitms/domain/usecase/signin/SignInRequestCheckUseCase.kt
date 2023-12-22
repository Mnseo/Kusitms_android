package com.kusitms.domain.usecase.signin

import com.kusitms.domain.model.signin.SignInRequestCheckModel
import com.kusitms.domain.repository.SignInRepository
import javax.inject.Inject

class SignInRequestCheckUseCase @Inject constructor(
    private val signInRepository: SignInRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ): Result<SignInRequestCheckModel> {
        return signInRepository.signInRequestCheck(email, password)
    }
}
