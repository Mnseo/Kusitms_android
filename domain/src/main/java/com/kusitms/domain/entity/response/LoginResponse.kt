package com.kusitms.domain.entity.response

import com.kusitms.domain.entity.BaseResponse
import com.kusitms.domain.entity.Result


data class LoginResponsePayload(
    val accessToken: String,
    val response: LoginResponse
    )

class LoginResponse(
    result: Result,
    payload: LoginResponsePayload
): BaseResponse<LoginResponsePayload>(result = result, payload = payload)