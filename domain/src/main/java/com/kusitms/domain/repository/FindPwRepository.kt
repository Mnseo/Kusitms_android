package com.kusitms.domain.repository

import com.kusitms.domain.model.findpw.FindPwCheckEmailModel
import com.kusitms.domain.model.findpw.FindPwCodeVerifyModel


interface FindPwRepository {
    suspend fun FindPwEmailCheck(email:String): Result<FindPwCheckEmailModel>

    suspend fun SendCode(email: String): Result<Unit>

    suspend fun VerifyCode(email: String, code:String) : Result<FindPwCodeVerifyModel>

    suspend fun UpdatePassword(email:String, password:String) : Result<Unit>
}