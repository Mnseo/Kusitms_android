package com.kusitms.domain.usecase.home

import com.kusitms.domain.model.home.AttendQRModel
import com.kusitms.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAttendQrUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    operator fun invoke(
        curriculumId: Int
    ): Flow<AttendQRModel> = flow {
        homeRepository.getAttendQrText(
            curriculumId =  curriculumId
        ).onSuccess {
            return@flow emit(it)
        }.onFailure {
            throw it
        }
    }
}