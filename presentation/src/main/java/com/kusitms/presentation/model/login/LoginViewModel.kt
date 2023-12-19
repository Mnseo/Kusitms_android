package com.kusitms.presentation.model.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


enum class LoginStatus { SUCCESS, ERROR, DEFAULT}

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): ViewModel() {
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _loginStatus = MutableStateFlow(LoginStatus.DEFAULT)
    val loginStatus: StateFlow<LoginStatus> = _loginStatus

    fun updateEmail(email: String) {
        _email.value = email
    }

    fun updatePassword(password: String) {
        _password.value = password
    }

    fun updateLoginStatus(loginStatus: LoginStatus) {
        _loginStatus.value = loginStatus
    }

    fun validateLogin() {
        viewModelScope.launch {
            val email = email.value
            val password = password.value
            loginUseCase(email,password)
                .onSuccess {
                    updateLoginStatus(LoginStatus.SUCCESS)
                }.onFailure {
                    Timber.e(it)
                    updateLoginStatus(LoginStatus.ERROR)
                }
//            when (val response = loginUseCase(email, password)) {
//                is ApiResult.Success -> {
//                    updateLoginStatus(LoginStatus.SUCCESS)
//                    Timber.tag("LoginSuccess_result")
//                        .d("Code: " + response.data.result.code + " " + "\n" + " Message: " + response.data.result.message)
//                    Log.d(
//                        "LoginSuccess_payload",
//                        "atk: ${response.data.payload.accessToken} \n rfk: ${response.data.payload.refreshToken}"
//                    )
//                }
//                is ApiResult.ApiError -> {
//                    updateLoginStatus(LoginStatus.ERROR)
//                }
//
//                is ApiResult.Failure -> {
//                    updateLoginStatus(LoginStatus.ERROR)
//                    Timber.e(response.throwable)
//                }
//                else -> { updateLoginStatus(LoginStatus.ERROR) }
//            }
        }
    }

}