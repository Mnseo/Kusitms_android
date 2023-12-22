package com.kusitms.data.remote.entity.response

import com.kusitms.data.remote.entity.BaseResponse
import com.kusitms.data.remote.entity.Result

data class FindPwCheckEmailPayload(
    val isEmailExist: Boolean
)


class FindPwCheckEmailResponse(
    result:Result,
    payload: FindPwCheckEmailPayload
): BaseResponse<FindPwCheckEmailPayload>(result,payload)