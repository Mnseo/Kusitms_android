package com.kusitms.domain.usecase.report

import com.kusitms.domain.model.report.ReportContentModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ReportUseCase @Inject constructor() {
    operator fun invoke(
        content : ReportContentModel
    ): Flow<Unit> = flow {
        //TODO data층과 연동 필요
        emit(Unit)
    }
}