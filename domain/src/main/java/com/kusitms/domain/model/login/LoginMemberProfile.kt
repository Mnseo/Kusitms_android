package com.kusitms.domain.model.login

data class LoginMemberProfile(
    val name: String,
    val email: String,
    val period: String?,
    val phoneNumber: String,
    val memberDetailExist: Boolean
)