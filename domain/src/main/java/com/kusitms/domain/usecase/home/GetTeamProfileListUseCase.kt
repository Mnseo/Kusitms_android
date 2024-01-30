package com.kusitms.domain.usecase.home

import com.kusitms.domain.model.home.TeamProfileModel
import com.kusitms.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTeamProfileListUseCase @Inject constructor(
    private val homeRepository: HomeRepository,
) {
    operator fun invoke(
        teamId: Int,
    ): Flow<List<TeamProfileModel>> = flow {
        homeRepository.getMemberInfoList(
            teamId = teamId
        ).onSuccess {
                emit(it)
            }.onFailure {
                throw it
            }
    }
}