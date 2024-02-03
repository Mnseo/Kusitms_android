package com.kusitms.data.remote.entity.response.home

import com.kusitms.domain.model.home.AttendModel

data class AttendPayload(
    val penalty: Int,
    val present: Int,
    val absent: Int,
    val late: Int,
    val passYn: String
)

fun AttendPayload.toModel() =
    AttendModel(
        penalty = penalty ?: 0,
        present = present ?: 0,
        absent = absent ?: 0,
        late = late ?: 0,
        passYn = passYn ?: "수료 가능한 점수에요"
    )
