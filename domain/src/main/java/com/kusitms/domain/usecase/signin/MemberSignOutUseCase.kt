package com.kusitms.domain.usecase.signin

import com.kusitms.domain.repository.AuthRepository
import javax.inject.Inject

class MemberSignOutUseCase@Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): Result<Unit> {
        return authRepository.signOutMember()
    }
}