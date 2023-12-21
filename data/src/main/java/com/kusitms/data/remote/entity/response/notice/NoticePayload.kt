package com.kusitms.data.remote.entity.response.notice

import com.kusitms.domain.model.notice.CurriculumModel
import com.kusitms.domain.model.notice.NoticeModel

data class NoticePayload(
    val noticeId : Int? = 0,
    val curriculum : String? = "",
    val team : String? = "",
    val title : String? = "",
    val content : String? = "",
    val date : String? = "",
    val imageUrl : String? = "",
    val isRead : Boolean? = false,
    val name : String? = "",
    val profileImage : String? = ""
)

fun NoticePayload.toModel() =
    NoticeModel(
        noticeId = noticeId ?: 0,
        curriculum = curriculum ?: "",
        team = team ?: "",
        title = title ?: "",
        content = content ?: "",
        date = date ?: "",
        imageUrl = imageUrl ?: "",
        isRead = isRead ?: false,
        name = name ?: "",
        profileImage = profileImage ?: ""
    )