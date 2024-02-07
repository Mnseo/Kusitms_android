package com.kusitms.data.remote.entity.request

import com.kusitms.domain.model.login.LoginEmailModel
import com.kusitms.domain.model.login.LoginEmailVerifyModel
import com.kusitms.domain.model.login.LoginMemberModel
import com.kusitms.domain.model.login.LoginPasswordModel

data class LoginRequestBody(
    val email: String,
    val password: String
)

fun mapToLoginRequestBody(model: LoginMemberModel): LoginRequestBody {
    return LoginRequestBody(
        email = model.email,
        password = model.password
    )
}

data class CheckEmailRequestBody(
    val email: String
)

fun mapToEmailRequestBody(model: LoginEmailModel): CheckEmailRequestBody {
    return CheckEmailRequestBody(
        email =  model.email
    )
}

data class EmailVerifyRequestBody(
    val email: String,
    val code : String
)


fun mapToEmailVerifyBody(model: LoginEmailVerifyModel): EmailVerifyRequestBody {
    return EmailVerifyRequestBody(
        email = model.email,
        code =  model.code
    )
}

data class PasswordRequestBody(
    val password: String
)

fun mapToPasswordRequestBody(model: LoginPasswordModel): PasswordRequestBody {
    return PasswordRequestBody(
        password =  model.password
    )
}