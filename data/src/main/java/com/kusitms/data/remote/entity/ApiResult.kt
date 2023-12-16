package com.kusitms.data.remote.entity

import retrofit2.Response



sealed interface ApiResult<T> {
    data class Success<T>(val data:T): ApiResult<T>
    data class Failure<T>(val throwable: Throwable) : ApiResult<T>
    data class ApiError<T>(val code: Int, val message: String) : ApiResult<T>


    fun <T> ApiResult<T>.onSuccess(action: (T) -> Unit): ApiResult<T> {
        if (this is Success) {
            action.invoke(this.data)
        }
        return this
    }

    fun <T> ApiResult<T>.onError(action: (Throwable) -> Unit): ApiResult<T> {
        if (this is Failure) {
            action.invoke(this.throwable)
        }
        return this
    }

    fun <T : Any> ApiResult(call: () -> Response<BaseResponse<T>>): ApiResult<T> {
        return try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if(body != null) {
                    if(body.payload != null) {
                        Success(body.payload)
                    } else {

                    }
                } else {
                    println("response is Successful but body is null")
                    ApiError(response.code(), "Empty Response")
                }
            } else {
                println("response is not successful")
                ApiError(response.code(), response.message())
            }
        } catch(e: Throwable) {
            println("Throwable")
            Failure(e)
        } as ApiResult<T>
    }
}

