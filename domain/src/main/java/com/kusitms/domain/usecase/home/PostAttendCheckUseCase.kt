package com.kusitms.domain.usecase.home

import com.kusitms.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostAttendCheckUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke(
        curriculumId: Int,
        qrText: String
    ): Result<Unit>  {
            return homeRepository.postAttendCheck(curriculumId, qrText)
        }
}