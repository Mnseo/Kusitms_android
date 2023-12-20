package com.kusitms.domain.usecase


import com.kusitms.domain.repository.LoginRepository
import javax.inject.Inject

class LoginMemberUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ): Result<Unit> {
        return loginRepository.LoginMember(email,password)
    }

}
