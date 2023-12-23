package com.kusitms.domain.model.notice

data class CurriculumModel(
    val curriculumId : Int,
    val curriculumName : String = "",
    val title : String = "",
    val curriculumNoticeList : List<NoticeModel> = emptyList()
)