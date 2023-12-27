package com.kusitms.data.remote.entity.request

import com.kusitms.domain.model.findpw.FindPwNewPasswordModel

data class UpdatePasswordRequest(
    val password:String
)

fun FindPwNewPasswordModel.toModel() =
    UpdatePasswordRequest(
        password = password
    )