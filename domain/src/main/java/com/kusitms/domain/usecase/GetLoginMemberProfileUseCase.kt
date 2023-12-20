package com.kusitms.domain.usecase

import com.kusitms.domain.model.login.LoginMemberProfile
import com.kusitms.domain.repository.SignInRepository
import javax.inject.Inject

class GetLoginMemberProfileUseCase @Inject constructor(
    private val signInRepository: SignInRepository
) {
    suspend fun fetchLoginMemberProfile(): Result<LoginMemberProfile> {
        return signInRepository.fetchLoginMemberProfile()
    }
}