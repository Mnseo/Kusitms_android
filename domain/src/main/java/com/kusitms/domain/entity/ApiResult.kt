package com.kusitms.domain.entity

sealed interface ApiResult<T> {
    data class Success<T>(val data:T): ApiResult<T>
    data class Failure<T>(val throwable: Throwable) : ApiResult<T>
    data class ApiError(val code: Int, val message: String) : ApiResult<Any?>


    fun <T> ApiResult<T>.onSuccess(action: (T) -> Unit): ApiResult<T> {
        if (this is ApiResult.Success) {
            action.invoke(this.data)
        }
        return this
    }

    fun <T> ApiResult<T>.Error(action: OnErrorAction): ApiResult<T> {
        return this
    }


    fun <T : Any> ApiResult(call: () -> BaseResponse<T>): ApiResult<T> {
        return runCatching {
            val response = call()
            if (response.hashCode() == 200) {
                ApiResult.Success(response.payload)
            } else {
                ApiResult.ApiError(response.result.code, response.result.message)
            }
        }.getOrElse {
            ApiResult.Failure(it)
        } as ApiResult<T>
    }

}

