package com.kusitms.data

import com.kusitms.domain.repository.LoginRepository
import javax.inject.Inject


class LoginUseCase @Inject constructor(
    private val LogInRepository: LoginRepository,
) {
}


