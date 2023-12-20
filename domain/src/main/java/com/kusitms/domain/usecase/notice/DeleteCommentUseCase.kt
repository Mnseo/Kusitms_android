package com.kusitms.domain.usecase.notice

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DeleteCommentUseCase @Inject constructor() {
    operator fun invoke(
        commentId : Int
    ): Flow<Unit> = flow {
        //TODO data층과 연동 필요
        emit(Unit)
    }
}