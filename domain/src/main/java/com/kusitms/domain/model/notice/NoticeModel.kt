package com.kusitms.domain.model.notice

data class NoticeModel(
    val noticeId : Int = 0,
    val curriculum : String = "",
    val team : String = "",
    val title : String = "",
    val content : String = "",
    val date : String = "",
    val imageUrl : String = "",
    val isRead : Boolean = false,
    val name : String = "",
    val profileImage : String = ""
)