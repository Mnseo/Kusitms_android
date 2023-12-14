package com.kusitms.domain.usecase.notice

import com.kusitms.domain.model.notice.CurriculumModel
import com.kusitms.domain.model.notice.curriculumDummy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCurriculumListUseCase @Inject constructor() {
    operator fun invoke(

    ): Flow<List<CurriculumModel>> = flow {
        //TODO data층과 연동 필요
        emit(curriculumDummy)
    }
}