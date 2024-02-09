package com.kusitms.data.remote.entity.request

import com.kusitms.domain.model.home.AttendCheckModel

data class AttendCheckRequestBody(
    val curriculumId: Int,
    val text: String
)

fun mapToAttendCheckRequestBody(model: AttendCheckModel): AttendCheckRequestBody {
    return AttendCheckRequestBody(
        curriculumId = model.curriculumId,
        text = model.text
    )
}