package com.kusitms.domain.repository

import com.kusitms.domain.model.login.LoginMemberProfile


interface LoginRepository {
    suspend fun LoginMember(email: String, password: String): Result<Unit>

    suspend fun fetchLoginMemberProfile(): Result<LoginMemberProfile>
}