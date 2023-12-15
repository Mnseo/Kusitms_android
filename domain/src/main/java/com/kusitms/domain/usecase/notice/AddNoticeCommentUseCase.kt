package com.kusitms.domain.usecase.notice

import com.kusitms.domain.model.notice.CommentContentModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AddNoticeCommentUseCase @Inject constructor() {
    operator fun invoke(
        noticeId : Int,
        content : CommentContentModel
    ): Flow<Unit> = flow {
        //TODO data층과 연동 필요
        emit(Unit)
    }
}