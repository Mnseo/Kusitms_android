package com.kusitms.domain.entity

import com.kusitms.domain.entity.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

sealed interface ApiResult<T> {
    data class Success<T>(val data:T): ApiResult<T>
    data class Error(val code: String, val message: String) : ApiResult<Nothing>


    fun <T> ApiResult<T>.onSuccess(action: (T) -> Unit): ApiResult<T> {
        if (this is ApiResult.Success) {
            action.invoke(this.data)
        }
        return this
    }

    fun <T> ApiResult<T>.Error(action: OnErrorAction): ApiResult<T> {
        return this
    }

}