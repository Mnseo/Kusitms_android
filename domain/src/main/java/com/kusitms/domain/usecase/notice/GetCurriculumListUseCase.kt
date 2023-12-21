package com.kusitms.domain.usecase.notice

import com.kusitms.domain.model.notice.CurriculumModel
import com.kusitms.domain.model.notice.NoticeModel
import com.kusitms.domain.model.notice.curriculumDummy
import com.kusitms.domain.repository.NoticeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCurriculumListUseCase @Inject constructor(
    private val noticeRepository: NoticeRepository
) {
    operator fun invoke(): Flow<List<CurriculumModel>> = flow {
        noticeRepository.getCurriculumList()
            .onSuccess {
                emit(it.map {
                    it
                })
            }.onFailure {
                throw it
            }
    }
}