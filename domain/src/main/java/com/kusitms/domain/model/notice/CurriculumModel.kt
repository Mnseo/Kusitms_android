package com.kusitms.domain.model.notice

data class CurriculumModel(
    val curriculumId : Int,
    val curriculumName : String = "",
    val title : String,
    val curriculumNoticeList : List<NoticeModel> = noticeDummy
)

val curriculumDummy = listOf(
    CurriculumModel(
        1,
        title = "전체OT",
    ),
    CurriculumModel(
        2,
        title = "기업프로젝트",
        curriculumNoticeList = emptyList()
    ),
    CurriculumModel(
        3,
        title = "큐커톤",
        curriculumNoticeList = noticeDummy.take(2)
    )
)