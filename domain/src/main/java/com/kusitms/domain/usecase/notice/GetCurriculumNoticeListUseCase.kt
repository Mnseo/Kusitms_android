package com.kusitms.domain.usecase.notice

import com.kusitms.domain.model.notice.NoticeModel
import com.kusitms.domain.repository.NoticeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

//사용할 지 말지 판단하기
class GetCurriculumNoticeListUseCase  @Inject constructor(
    private val noticeRepository: NoticeRepository
) {
    operator fun invoke(
        curriculumId : Int
    ): Flow<List<NoticeModel>> = flow {

    }
}