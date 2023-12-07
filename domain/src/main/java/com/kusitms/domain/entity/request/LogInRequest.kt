package com.kusitms.domain.entity.request

data class LogInRequest(
    val authority: String,
    val email:String,
    val password:String
)
