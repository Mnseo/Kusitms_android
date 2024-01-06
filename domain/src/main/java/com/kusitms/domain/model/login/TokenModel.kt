package com.kusitms.domain.model.login

data class TokenModel(
    val authToken: String,
    val refreshToken: String
)