package com.kusitms.data.remote.entity.response.home

import com.kusitms.domain.model.home.AttendInfoModel

data class AttendInfoPayload(
    val curriculumId: Int,
    val curriculumName: String,
    val isAttended: Boolean,
    val date: String
)

fun AttendInfoPayload.toModel() =
    AttendInfoModel(
        curriculumId =  curriculumId ?: 0,
        curriculumName =  curriculumName ?: "",
        isAttended = isAttended ?: false,
        date = date ?: "2월 17일"
    )