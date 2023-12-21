package com.kusitms.domain.usecase.notice

import com.kusitms.domain.model.notice.CommentModel
import com.kusitms.domain.model.notice.CurriculumModel
import com.kusitms.domain.model.notice.dummyCommentList
import com.kusitms.domain.repository.NoticeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNoticeCommentListUseCase @Inject constructor(
    private val noticeRepository: NoticeRepository
) {
    operator fun invoke(
        noticeId : Int
    ): Flow<List<CommentModel>> = flow {
        noticeRepository.getNoticeCommentList(noticeId)
            .onSuccess {
                emit(it)
            }.onFailure {
                throw it
            }
    }
}