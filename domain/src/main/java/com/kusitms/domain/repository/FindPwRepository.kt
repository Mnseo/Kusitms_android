package com.kusitms.domain.repository


interface FindPwRepository {
    suspend fun FindPwEmailCheck(email:String): Result<Unit>

    suspend fun FindPwVerifyCode(email: String, code:String) : Result<Unit>
}