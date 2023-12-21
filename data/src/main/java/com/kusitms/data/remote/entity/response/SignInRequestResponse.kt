package com.kusitms.data.remote.entity.response

import com.kusitms.data.remote.entity.BaseResponse
import com.kusitms.data.remote.entity.Result
import com.kusitms.domain.model.signin.SignInRequestModel


data class SignInRequestPayload(
    val checkRegistered: String
)

fun SignInRequestPayload.toModel() =
    SignInRequestModel(
        checkRegistered = checkRegistered
    )

class SignInRequestResponse(
    result: Result,
    payload: SignInRequestPayload
): BaseResponse<SignInRequestPayload>(result, payload)