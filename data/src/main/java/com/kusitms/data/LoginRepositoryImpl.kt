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
        return kusitmsApi.LoginMember(email, password)
    }
}
