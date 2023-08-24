package com.kusitms.data.usecase

import com.kusitms.data.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    suspend fun signInMember() {

    }
}