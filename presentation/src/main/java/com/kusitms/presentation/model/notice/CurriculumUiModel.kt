package com.kusitms.presentation.model.notice

data class CurriculumUiModel(
    val curriculumId : Int,
    val curriculumName : String = "",
    val title : String,
    val curriculumNoticeList : List<NoticeUiModel> = noticeDummy
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