package com.kusitms.presentation.model.notice

import com.kusitms.domain.model.notice.NoticeModel
import com.kusitms.domain.model.notice.noticeDummy

data class CurriculumUiModel(
    val curriculumId : Int,
    val curriculumName : String = "",
    val title : String,
    val curriculumNoticeList : List<NoticeModel> = noticeDummy
)

val curriculumDummy = listOf(
    CurriculumUiModel(
        1,
        title = "전체OT",
    ),
    CurriculumUiModel(
        2,
        title = "기업프로젝트",
        curriculumNoticeList = emptyList()
    ),
    CurriculumUiModel(
        3,
        title = "큐커톤",
        curriculumNoticeList = noticeDummy.take(2)
    )
)