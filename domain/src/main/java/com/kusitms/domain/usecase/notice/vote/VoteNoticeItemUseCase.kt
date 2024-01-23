package com.kusitms.domain.usecase.notice.vote

import com.kusitms.domain.repository.NoticeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class VoteNoticeItemUseCase @Inject constructor(
    private val noticeRepository: NoticeRepository
) {
    operator fun invoke(
        voteItemId : Int
    ): Flow<Int> = flow {
        noticeRepository.voteNoticeItem(voteItemId)
            .onSuccess {
                emit(it)
            }.onFailure {
                throw it
            }
    }
}