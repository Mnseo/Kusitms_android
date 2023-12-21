package com.kusitms.domain.usecase.notice

import com.kusitms.domain.model.notice.NoticeModel
import com.kusitms.domain.repository.NoticeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNoticeDetailUseCase @Inject constructor(
    private val noticeRepository: NoticeRepository
) {
    operator fun invoke(noticeId : Int): Flow<NoticeModel> = flow {
        noticeRepository.getNoticeDetail(
            noticeId
        ).onSuccess {
            emit(it)
        }.onFailure {
            throw it
        }
    }
}