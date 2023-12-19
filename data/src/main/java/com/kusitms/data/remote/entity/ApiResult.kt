package com.kusitms.data.remote.entity

import retrofit2.Response

sealed interface ApiResult<out T> {
    data class Success<out T>(val data: T) : ApiResult<T>
    data class Failure(val throwable: Throwable) : ApiResult<Nothing>
    object ApiError : ApiResult<Nothing>

}

fun <T> ApiResult<T>.onSuccess(action: (T) -> Unit): ApiResult<T> {
    if (this is ApiResult.Success) {
        action.invoke(this.data)
    }
    return this
}

fun ApiResult<*>.onError(action: (Throwable) -> Unit): ApiResult<*> {
    if (this is ApiResult.Failure) {
        action.invoke(this.throwable)
    }
    return this
}

fun <T : Any> callApi(call: () -> Response<BaseResponse<T>>): ApiResult<T> {
    return try {
        val response = call()
        if (response.isSuccessful) {
            val body = response.body()
            if(body != null) {
                if(body.payload != null) {
                    ApiResult.Success(body.payload)
                } else {
                    println("response is Successful but payload is null")
                    ApiResult.ApiError
                }
            } else {
                println("response is Successful but body is null")
                ApiResult.ApiError
            }
        } else {
            println("response is not successful")
            ApiResult.ApiError
        }
    } catch(e: Throwable) {
        println("Throwable")
        ApiResult.Failure(e)
    }
}
