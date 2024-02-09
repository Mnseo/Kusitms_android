package com.kusitms.domain.usecase.home

import com.kusitms.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostAttendCheckUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    operator fun invoke(
        curriculumId: Int,
        qrText: String
    ): Flow<Unit> = flow {
        homeRepository.postAttendCheck(
            curriculumId, qrText
        ).onSuccess {
            emit(Unit)
        }.onFailure {
            throw it
        }
    }
}