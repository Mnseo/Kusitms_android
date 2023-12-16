package com.kusitms.domain.repository


import com.kusitms.domain.entity.response.LoginResponse

interface LoginRepository {
    suspend fun LoginMember(email: String, password: String): LoginResponse
}