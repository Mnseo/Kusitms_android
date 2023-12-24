package com.kusitms.domain.usecase.findpw

import com.kusitms.domain.repository.FindPwRepository

class FindPwUpdatePasswordUseCase(
    private val findPwRepository: FindPwRepository
) {
    suspend operator fun invoke(email: String, password: String): Result<Unit> {
        return findPwRepository.UpdatePassword(email, password)
    }
}