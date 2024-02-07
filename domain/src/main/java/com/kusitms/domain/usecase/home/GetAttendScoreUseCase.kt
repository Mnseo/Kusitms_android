package com.kusitms.domain.usecase.home

import com.kusitms.domain.model.home.AttendModel
import com.kusitms.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAttendScoreUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    operator fun invoke(): Flow<AttendModel> = flow {
        homeRepository.getAttendScore()
            .onSuccess {
                emit(it)
            }.onFailure {
                throw it
            }
    }
}