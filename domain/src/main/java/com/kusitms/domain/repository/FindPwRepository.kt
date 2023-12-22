package com.kusitms.domain.repository

import com.kusitms.domain.model.findpw.FindPwCheckEmailModel


interface FindPwRepository {
    suspend fun FindPwEmailCheck(email:String): Result<FindPwCheckEmailModel>

    suspend fun SendCode(email: String): Result<Unit>

    suspend fun FindPwVerifyCode(email: String, code:String) : Result<Unit>
}