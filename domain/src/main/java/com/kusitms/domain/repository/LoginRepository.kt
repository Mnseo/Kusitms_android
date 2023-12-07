package com.kusitms.domain.repository

import com.kusitms.domain.entity.BaseResponse
import com.kusitms.domain.entity.request.LoginRequest
import com.kusitms.domain.entity.response.LoginResponse

interface LoginRepository {
    suspend fun LoginMember(request:LoginRequest) : LoginResponse

}