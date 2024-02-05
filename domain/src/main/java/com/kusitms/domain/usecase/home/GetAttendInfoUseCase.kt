package com.kusitms.domain.usecase.home

import com.kusitms.domain.model.home.AttendInfoModel
import com.kusitms.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAttendInfoUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    operator fun invoke(): Flow<AttendInfoModel> = flow {
        homeRepository.getAttendInfo()
            .onSuccess {
                emit(it)
            }.onFailure {
                throw it
            }
    }
}