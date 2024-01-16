package com.kusitms.domain.usecase.notice

import com.kusitms.domain.model.notice.CommentModel
import com.kusitms.domain.repository.NoticeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetChildCommentListUseCase @Inject constructor(
    private val noticeRepository: NoticeRepository
) {
    operator fun invoke(
        commentId : Int
    ): Flow<List<CommentModel>> = flow {
        noticeRepository.getChildCommentList(commentId)
            .onSuccess {
                emit(it)
            }.onFailure {
                throw it
            }
    }
}