package com.kusitms.data.remote.entity.response.notice

import com.kusitms.domain.model.notice.CurriculumModel
import com.kusitms.domain.model.notice.NoticeModel

data class CurriculumPayload(
    val curriculumId : Int? = 0,
    val curriculumName : String? = "",
    val title : String? = "",
    val curriculumNoticeList : List<NoticeModel>? = emptyList()
)

fun CurriculumPayload.toModel() =
    CurriculumModel(
        curriculumId = curriculumId ?: 0,
        curriculumName = curriculumName ?: "",
        title = title ?: "",
        curriculumNoticeList = curriculumNoticeList ?: emptyList()
    )