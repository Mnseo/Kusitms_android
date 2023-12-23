package com.kusitms.domain.usecase.changepw

import com.kusitms.domain.model.notice.NoticeModel
import com.kusitms.domain.repository.ChangePwRepository
import com.kusitms.domain.repository.NoticeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CheckPasswordUseCase  @Inject constructor(
    private val changePwRepository: ChangePwRepository
) {
    operator fun invoke(password:String): Flow<Boolean> = flow {
        changePwRepository.checkPassword(password)
            .onSuccess {
                emit(it)
            }.onFailure {
                throw it
            }
    }
}