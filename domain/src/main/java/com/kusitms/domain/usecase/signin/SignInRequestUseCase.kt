package com.kusitms.domain.usecase.signin

import com.kusitms.domain.repository.SignInRepository
import javax.inject.Inject

class SignInRequestUseCase @Inject constructor(
    private val signInRepository: SignInRepository

) {
    suspend operator fun invoke(
        email:String,
        password:String
    ): Result<Unit> {
        return signInRepository.signInRequest(email, password)
    }

}