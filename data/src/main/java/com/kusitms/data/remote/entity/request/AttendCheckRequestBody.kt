package com.kusitms.data.remote.entity.request

import com.kusitms.domain.model.home.AttendCheckModel

data class AttendCheckRequestBody(
    val curriculumId: Int,
    val text: String
)

fun AttendCheckModel.toBody() =
    AttendCheckRequestBody(
        curriculumId, text
    )
