package com.kusitms.domain.repository


interface FindPwRepository {
    suspend fun FindPwEmail(email:String)
}