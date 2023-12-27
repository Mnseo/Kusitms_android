package com.kusitms.domain.usecase.changepw

import com.kusitms.domain.repository.ChangePwRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdatePasswordAsLoggedInUseCase  @Inject constructor(
    private val changePwRepository: ChangePwRepository
) {
    operator fun invoke(password:String): Flow<Unit> = flow {
        changePwRepository.updatePasswordAsLoggedIn(password)
            .onSuccess {
                emit(it)
            }.onFailure {
                throw it
            }
    }
}