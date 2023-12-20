package com.kusitms.domain.repository

import com.kusitms.domain.model.login.LoginMemberProfile

interface SignInRepository {
    suspend fun fetchLoginMemberProfile(): Result<LoginMemberProfile>
}