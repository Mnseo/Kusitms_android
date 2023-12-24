package com.kusitms.data.remote.entity.request

import com.kusitms.domain.model.findpw.FindPwNewPasswordModel

data class UpdateNewPasswordRequestBody(
    val password:String
)

fun FindPwNewPasswordModel.toModel() =
    UpdateNewPasswordRequestBody(
        password = password
    )