package com.kusitms.domain.usecase.notice

import com.kusitms.domain.model.notice.NoticeModel
import com.kusitms.domain.model.notice.noticeDummy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNoticeDetailUseCase @Inject constructor() {
    operator fun invoke(noticeId : Int): Flow<NoticeModel> = flow {
        //TODO data층과 연동 필요
        emit(noticeDummy.find { it.noticeId == noticeId } ?: throw RuntimeException("공지사항이 없습니다."))
    }
}