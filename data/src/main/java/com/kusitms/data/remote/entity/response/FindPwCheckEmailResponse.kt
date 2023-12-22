package com.kusitms.data.remote.entity.response

import com.kusitms.data.remote.entity.BaseResponse
import com.kusitms.data.remote.entity.Result
import com.kusitms.domain.model.findpw.FindPwCheckEmailModel

data class FindPwCheckEmailPayload(
    val isEmailExist: Boolean
)

fun FindPwCheckEmailPayload.toModel() =
    FindPwCheckEmailModel(
        isEmailExist = isEmailExist
    )

class FindPwCheckEmailResponse(
    result:Result,
    payload: FindPwCheckEmailPayload
): BaseResponse<FindPwCheckEmailPayload>(result,payload)