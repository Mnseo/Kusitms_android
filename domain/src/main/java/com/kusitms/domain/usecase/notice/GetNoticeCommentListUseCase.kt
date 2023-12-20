package com.kusitms.domain.usecase.notice

import com.kusitms.domain.model.notice.CommentModel
import com.kusitms.domain.model.notice.dummyCommentList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNoticeCommentListUseCase @Inject constructor() {
    operator fun invoke(
        noticeId : Int
    ): Flow<List<CommentModel>> = flow {
        //TODO data층과 연동 필요
        emit(dummyCommentList)
    }
}