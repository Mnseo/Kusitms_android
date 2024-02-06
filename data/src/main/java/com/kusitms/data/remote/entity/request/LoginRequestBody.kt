package com.kusitms.data.remote.entity.request

data class LoginRequestBody(
    val email: String,
    val password: String
)

data class CheckEmailRequestBody(
    val email: String
)

data class EmailVerifyRequestBody(
    val email: String,
    val code : String
)

data class passwordRequestBody(
    val password: String
)