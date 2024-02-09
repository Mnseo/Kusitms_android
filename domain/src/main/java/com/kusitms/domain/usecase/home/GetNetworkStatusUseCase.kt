package com.kusitms.domain.usecase.home

import com.kusitms.domain.repository.AuthRepository
import javax.inject.Inject

class GetNetworkStatusUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke(): Boolean {
        return authRepository.checkInternetConnection()
    }
}