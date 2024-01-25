package com.kusitms.data.remote.entity.response.home

import com.kusitms.domain.model.home.CurriculumRecentModel

data class CurriculumRecentPayload(
    val curriculumName: String,
    val time: String,
    val place: String,
    val wifiName: String,
    val wifiPassword: String,
)

fun CurriculumRecentPayload.toModel() =
    CurriculumRecentModel(
        curriculumName, time, place, wifiName, wifiPassword
    )
