package com.kusitms.data

import com.kusitms.data.remote.api.KusitmsApi
import com.kusitms.domain.entity.response.LoginResponse
import com.kusitms.domain.repository.LoginRepository
import javax.inject.Inject


class LoginRepositoryImpl @Inject constructor(
    private val kusitmsApi: KusitmsApi
): LoginRepository {
    override suspend fun LoginMember(
        email: String,
        password: String
    ): LoginResponse {
        // 받고 API 성공/실패 처리 ApiResult<Unit> + Access Token Data store 저장
        // try catch -> body
        return kusitmsApi.LoginMember(email, password)
    }
}
