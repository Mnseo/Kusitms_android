package com.kusitms.domain.usecase.notice

import com.kusitms.domain.model.notice.CommentContentModel
import com.kusitms.domain.repository.NoticeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AddNoticeChildCommentUseCase  @Inject constructor(
    private val noticeRepository: NoticeRepository
) {
    operator fun invoke(
        noticeId : Int,
        commentId : Int,
        content : CommentContentModel
    ): Flow<Unit> = flow {
        noticeRepository.addNoticeChildComment(
            noticeId = noticeId,
            commentId = commentId,
            commentContentModel = content
        ).onSuccess {
            //TODO 타입 변경
            emit(Unit)
        }.onFailure {
            throw it
        }
    }
}