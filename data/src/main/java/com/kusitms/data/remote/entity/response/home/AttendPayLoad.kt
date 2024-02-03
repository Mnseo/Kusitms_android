package com.kusitms.data.remote.entity.response.home

import com.kusitms.domain.model.home.AttendModel

data class AttendPayLoad(
    val attendId: Int,
    val curriculum: String,
    val date: String,
    val time: String,
    val status:String
)

fun AttendPayLoad.toModel() =
    AttendModel(
        attendId = attendId ?: 0,
        curriculum = curriculum ?: "",
        date = date ?: "",
        time = time ?: "",
        status = status ?: ""
    )
