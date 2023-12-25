package com.kusitms.domain.usecase.signin

import com.kusitms.domain.model.login.LoginMemberProfile
import com.kusitms.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthMemberProfileUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): Result<LoginMemberProfile?> {
        return authRepository.getLoginMemberProfile()
    }
}
