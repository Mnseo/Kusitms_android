package com.kusitms.presentation.model.notice

data class CurriculumUiModel(
    val curriculumId : Int,
    val curriculumName : String = "",
    val title : String,
    val curriculumNoticeList : List<NoticeUiModel> = emptyList()
)
