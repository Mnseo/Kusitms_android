package com.kusitms.presentation.model.notice

data class NoticeUiModel(
    val noticeId : Int,
    val curriculum : String = "",
    val team : String = "",
    val title : String,
    val content : String,
    val date : String,
    val imageUrl : String = "",
    val isRead : Boolean = false,
    val name : String = "",
    val profileImage : String = ""
)
