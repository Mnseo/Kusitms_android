package com.kusitms.domain.usecase

import com.kusitms.domain.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    suspend fun signInMember()
}