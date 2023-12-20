package com.kusitms.data.remote.entity.response

import com.kusitms.data.remote.entity.BaseResponse
import com.kusitms.data.remote.entity.Result


data class LoginMemberProfilePayload(
    val name:String,
    val period: String,
    val email:String,
    val phoneNumber:String,
    val memberDetailExist:Boolean
)


class LoginMemberProfileResponse(
    result: Result,
    payload: LoginMemberProfilePayload
): BaseResponse<LoginMemberProfilePayload>(result, payload)