package com.kusitms.data.remote.entity.response.notice

import com.kusitms.data.remote.entity.BaseResponse
import com.kusitms.domain.model.findpw.FindPwCodeVerifyModel
import com.kusitms.data.remote.entity.Result

data class FindPwCodeVerifyPayload(
    val isVerified: Boolean
)

fun FindPwCodeVerifyPayload.toModel() =
    FindPwCodeVerifyModel(
        isVerified = isVerified
    )

class FindPwCodeVerifyResponse(
    result:Result,
    payload: FindPwCodeVerifyPayload
): BaseResponse<FindPwCodeVerifyPayload>(result, payload)