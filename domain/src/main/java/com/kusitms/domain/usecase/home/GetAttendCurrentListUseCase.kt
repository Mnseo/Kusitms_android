package com.kusitms.domain.usecase.home

import com.kusitms.domain.model.home.AttendCurrentModel
import com.kusitms.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAttendCurrentListUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    operator fun invoke(): Flow<List<AttendCurrentModel>> = flow {
        homeRepository.getAttendCurrentList()
            .onSuccess {
                emit(it)
            }
            .onFailure {
                throw it
            }
    }
}