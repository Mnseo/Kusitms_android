package com.kusitms.data.remote.entity.response.home

import com.kusitms.domain.model.home.NoticeRecentModel

data class NoticeRecentPayload (
    val title: String,
    val noticeId: Int,
)

fun NoticeRecentPayload.toModel() =
    NoticeRecentModel(
        title = title,
        noticeId = noticeId
    )