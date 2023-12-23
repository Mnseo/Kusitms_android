package com.kusitms.domain.repository

interface ChangePwRepository {
    suspend fun checkPassword(password : String) : Result<Boolean>

    suspend fun updatePasswordAsLoggedIn(password: String) : Result<Unit>
}