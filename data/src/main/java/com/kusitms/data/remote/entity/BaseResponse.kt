package com.kusitms.data.remote.entity


open class BaseResponse<T>(
    val result: Result,
    val payload: T
)

open class nullExceptionResponse<T> (
    val result: Result,
    val payload: T?
    )

data class Result(
    val code: Int,
    val message: String
)