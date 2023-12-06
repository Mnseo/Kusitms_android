package com.kusitms.domain.entity.response

import com.kusitms.domain.entity.BaseResponse


data class LogInResponse(
    val accessToken: String,
    val refreshToken: String
)