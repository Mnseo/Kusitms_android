package com.kusitms.domain.usecase


import com.kusitms.domain.model.login.LoginMemberProfile
import com.kusitms.domain.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ): Result<Unit> {
        return loginRepository.LoginMember(email,password)
    }

    suspend fun fetchLoginMemberProfile(): Result<LoginMemberProfile> {
        return loginRepository.fetchLoginMemberProfile()
    }
}
