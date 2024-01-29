package com.kusitms.domain.model.notice

data class NoticeModel(
    val noticeId : Int = 0,
    val curriculumName : String = "",
    val teamName : String = "",
    val title : String = "",
    val content : String = "",
    val date : String = "",
    val imageUrl : List<String>? = emptyList(),
    val viewYn : Boolean = false,
    val name : String = "",
    val profileImage : String = ""
)