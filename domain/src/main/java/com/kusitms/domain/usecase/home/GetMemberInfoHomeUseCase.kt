package com.kusitms.domain.usecase.home

import com.kusitms.domain.model.home.HomeProfileModel
import com.kusitms.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMemberInfoHomeUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    operator fun invoke(): Flow<HomeProfileModel> = flow {
        homeRepository.getMemberInfoHome().onSuccess {
            emit(it)
        }.onFailure { throw it }
    }
}