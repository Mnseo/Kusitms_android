package com.kusitms.data.remote.entity.response.notice

import com.kusitms.domain.model.notice.NoticeModel

data class NoticePayload(
    val noticeId : Int? = 0,
    val curriculumName : String? = "",
    val teamName : String? = "",
    val title : String? = "",
    val content : String? = "",
    val date : String? = "",
    val imageUrl : List<String>? = emptyList(),
    val viewYn : Boolean? = false,
    val name : String? = "",
    val profileImage : String? = ""
)

data class NoticeDetailPayload(
    val noticeId : Int? = 0,
    val curriculum : String? = "",
    val team : String? = "",
    val title : String? = "",
    val content : String? = "",
    val date : String? = "",
    val imageUrl : List<String>? = emptyList(),
    val viewYn : Boolean? = false,
    val name : String? = "",
    val profileImage : String? = ""
)

fun NoticePayload.toModel() =
    NoticeModel(
        noticeId = noticeId ?: 0,
        curriculumName = curriculumName ?: "",
        teamName = teamName ?: "",
        title = title ?: "",
        content = content ?: "",
        date = date ?: "",
        imageUrl = imageUrl ?: emptyList(),
        viewYn = viewYn ?: false,
        name = name ?: "",
        profileImage = profileImage ?: ""
    )

fun NoticeDetailPayload.toModel() =
    NoticeModel(
        noticeId = noticeId ?: 0,
        curriculumName = curriculum ?: "",
        teamName = team ?: "",
        title = title ?: "",
        content = content ?: "",
        date = date ?: "",
        imageUrl = imageUrl ?: emptyList(),
        viewYn = viewYn ?: false,
        name = name ?: "",
        profileImage = profileImage ?: ""
    )