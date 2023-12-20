package com.kusitms.data.remote.entity.response

import com.kusitms.data.remote.entity.BaseResponse
import com.kusitms.data.remote.entity.Result


data class LoginResponsePayload(
    val accessToken: String,
    val refreshToken: String,
)

class LoginResponse(
    result: Result,
    payload: LoginResponsePayload
): BaseResponse<LoginResponsePayload>(result = result, payload = payload)

