package com.kusitms.domain.usecase.notice

import com.kusitms.domain.repository.NoticeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DeleteCommentUseCase @Inject constructor(
    private val noticeRepository: NoticeRepository
) {
    operator fun invoke(
        commentId : Int
    ): Flow<Unit> = flow {
        noticeRepository.deleteNoticeComment(commentId)
            .onSuccess {
                emit(it)
            }.onFailure {
                throw it
            }
    }
}