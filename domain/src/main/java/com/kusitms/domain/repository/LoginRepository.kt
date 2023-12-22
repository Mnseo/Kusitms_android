package com.kusitms.domain.repository



interface LoginRepository {
    suspend fun LoginMember(email: String, password: String): Result<Unit>

    suspend fun RefreshAccessToken(): Result<Unit>

}