package com.kusitms.domain.usecase.home

import com.kusitms.domain.model.home.NoticeRecentModel
import com.kusitms.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNoticeRecentUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    operator fun invoke(): Flow<List<NoticeRecentModel>> = flow {
        homeRepository.getNoticeRecent()
            .onSuccess {
                emit(it)
            }.onFailure {
                throw it
            }
    }
}