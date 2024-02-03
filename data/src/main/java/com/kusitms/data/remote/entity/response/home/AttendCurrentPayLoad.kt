package com.kusitms.data.remote.entity.response.home

import com.kusitms.domain.model.home.AttendCurrentModel

data class AttendCurrentPayLoad(
    val attendId: Int,
    val curriculum: String,
    val date: String,
    val time: String,
    val status:String
)

fun AttendCurrentPayLoad.toModel() =
    AttendCurrentModel(
        attendId = attendId ?: 0,
        curriculum = curriculum ?: "",
        date = date ?: "",
        time = time ?: "",
        status = status ?: ""
    )
