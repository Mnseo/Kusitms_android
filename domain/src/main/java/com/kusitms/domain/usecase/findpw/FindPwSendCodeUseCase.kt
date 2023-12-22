package com.kusitms.domain.usecase.findpw

import com.kusitms.domain.repository.FindPwRepository
import javax.inject.Inject

class FindPwSendCodeUseCase @Inject constructor(
    private val findPwRepository: FindPwRepository
) {
    suspend operator fun invoke(
        email: String
    ): Result<Unit> {
        return findPwRepository.SendCode(email)
    }
}