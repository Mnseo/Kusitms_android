package com.kusitms.domain.usecase.notice

import com.kusitms.domain.model.notice.NoticeModel
import com.kusitms.domain.model.notice.noticeDummy
import com.kusitms.domain.repository.NoticeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetNoticeListUseCase @Inject constructor(
    private val noticeRepository: NoticeRepository
) {
    operator fun invoke(): Flow<List<NoticeModel>> = flow {
        noticeRepository.getNoticeList()
            .onSuccess {
                emit(it)
            }.onFailure {
                throw it
            }
    }
}