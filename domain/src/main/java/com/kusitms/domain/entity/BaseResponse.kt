package com.kusitms.domain.entity


open class BaseResponse<T>(
    val result: Result,
    val payload: T
)

data class Result(
    val code: Int,
    val message: String
)