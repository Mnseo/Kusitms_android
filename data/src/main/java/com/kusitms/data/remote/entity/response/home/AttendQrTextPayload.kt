package com.kusitms.data.remote.entity.response.home

import com.kusitms.domain.model.home.AttendQRModel

data class AttendQrTextPayload(
    val qrText: String
)

fun AttendQrTextPayload.toModel() =
    AttendQRModel(
        qrText =  qrText
    )

