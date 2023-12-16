package com.kusitms.domain.usecase.notice

import com.kusitms.domain.model.notice.NoticeModel
import com.kusitms.domain.model.notice.noticeDummy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetNoticeListUseCase @Inject constructor() {
    operator fun invoke(

    ): Flow<List<NoticeModel>> = flow {
        //TODO data층과 연동 필요
        emit(noticeDummy)
    }
}