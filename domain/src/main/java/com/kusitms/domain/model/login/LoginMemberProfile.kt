package com.kusitms.domain.model.login

data class LoginMemberProfile(
    val name: String,
    val email: String,
    val period: String?,
    val phoneNumber: String,
    val memberDetailExist: Boolean
)

data class LoginMemberModel(
    val email:String,
    val password: String
)

data class LoginEmailModel(
    val email:String
)

data class LoginPasswordModel(
    val password: String
)

data class LoginEmailVerifyModel(
    val email: String,
    val code : String
)