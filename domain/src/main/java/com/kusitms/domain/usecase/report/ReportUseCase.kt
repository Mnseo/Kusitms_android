package com.kusitms.domain.usecase.report

import com.kusitms.domain.model.notice.ReportCommentContentModel
import com.kusitms.domain.model.report.ReportContentModel
import com.kusitms.domain.model.report.ReportResult
import com.kusitms.domain.repository.NoticeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ReportUseCase @Inject constructor(
    private val noticeRepository: NoticeRepository
) {
    operator fun invoke(
        reportCommentContentModel : ReportCommentContentModel
    ): Flow<ReportResult> = flow {
        noticeRepository.reportComment(
            reportCommentContentModel
        ).onSuccess {
            emit(it)
        }.onFailure {
            throw it
        }
    }
}