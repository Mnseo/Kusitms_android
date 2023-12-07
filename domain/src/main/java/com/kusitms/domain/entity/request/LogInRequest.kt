package com.kusitms.domain.entity.request

data class LoginRequest(
    val authority: String,
    val email:String,
    val password:String
)
