package com.kusitms.domain.usecase.notice

import com.kusitms.domain.model.notice.CommentContentModel
import com.kusitms.domain.repository.NoticeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AddNoticeCommentUseCase  @Inject constructor(
    private val noticeRepository: NoticeRepository
) {
    operator fun invoke(
        noticeId : Int,
        content : CommentContentModel
    ): Flow<Unit> = flow {
        noticeRepository.addNoticeComment(
            noticeId = noticeId,
            commentContentModel = content
        ).onSuccess {
            //TODO 타입 변경
            emit(Unit)
        }.onFailure {
            throw it
        }
    }
}