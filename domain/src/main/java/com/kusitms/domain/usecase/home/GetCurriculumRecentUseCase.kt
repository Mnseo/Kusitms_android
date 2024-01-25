package com.kusitms.domain.usecase.home

import com.kusitms.domain.model.home.CurriculumRecentModel
import com.kusitms.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCurriculumRecentUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    operator fun invoke(): Flow<CurriculumRecentModel> = flow {
        homeRepository.getCurriculumRecent()
            .onSuccess {
                emit(it)
            }.onFailure {
                throw it
            }
    }
}