package com.kusitms.domain.repository

import com.kusitms.domain.entity.BaseResponse
import com.kusitms.domain.entity.request.LogInRequest
import com.kusitms.domain.entity.response.LogInResponse

interface LogInRepository {
    suspend fun LoginMember(request:LogInRequest) : BaseResponse<LogInResponse>

}