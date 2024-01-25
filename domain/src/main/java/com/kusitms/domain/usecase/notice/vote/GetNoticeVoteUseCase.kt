package com.kusitms.domain.usecase.notice.vote

import com.kusitms.domain.model.notice.NoticeVoteModel
import com.kusitms.domain.repository.NoticeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNoticeVoteUseCase @Inject constructor(
    private val noticeRepository: NoticeRepository
) {
    operator fun invoke(
        noticeId : Int
    ): Flow<NoticeVoteModel> = flow {
        noticeRepository.getNoticeVote(noticeId)
            .onSuccess {
                emit(it)
            }.onFailure {
                throw it
            }
    }
}