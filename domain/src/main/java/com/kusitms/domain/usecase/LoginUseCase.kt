package com.kusitms.domain.usecase


import com.kusitms.domain.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ): Result<Unit> { // 단순히 성공/실패 여부만 반환
        return loginRepository.LoginMember(email,password)
    }
}
