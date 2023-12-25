package com.kusitms.domain.usecase.findpw

import com.kusitms.domain.repository.FindPwRepository
import javax.inject.Inject

class FindPwUpdatePasswordUseCase @Inject constructor(
    private val findPwRepository: FindPwRepository
) {
    suspend operator fun invoke(email: String, password: String): Result<Unit> {
        return findPwRepository.UpdatePassword(email, password)
    }
}