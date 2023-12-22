package com.kusitms.data.remote.entity.response

import com.kusitms.data.remote.entity.BaseResponse
import com.kusitms.data.remote.entity.Result
import com.kusitms.domain.model.signin.SignInRequestCheckModel


data class SignInRequestCheckPayload(
    val checkRegistered: String
)

fun SignInRequestCheckPayload.toModel() =
    SignInRequestCheckModel(
        checkRegistered = checkRegistered
    )

class SignInRequestResponse(
    result: Result,
    payload: SignInRequestCheckPayload
): BaseResponse<SignInRequestCheckPayload>(result, payload)