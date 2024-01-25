package com.kusitms.domain.usecase.home

import com.kusitms.domain.model.home.TeamMatchingModel
import com.kusitms.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTeamMatchUseCase @Inject constructor(
    private val homeRepository: HomeRepository,
) {
    operator fun invoke(): Flow<List<TeamMatchingModel>> = flow {
        homeRepository.getTeamMatch()
            .onSuccess {
                emit(it)
            }.onFailure {
                throw it
            }
    }
}