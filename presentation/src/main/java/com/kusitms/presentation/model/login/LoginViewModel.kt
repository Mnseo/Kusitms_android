package com.kusitms.presentation.model.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.usecase.signin.GetLoginMemberProfileUseCase
import com.kusitms.domain.usecase.signin.LoginMemberUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


enum class LoginStatus { SUCCESS, ERROR, DEFAULT}

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginMemberUseCase: LoginMemberUseCase,
    private val getLoginMemberUseCase: GetLoginMemberProfileUseCase
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
            Log.d("login_status", loginStatus.toString())
            loginMemberUseCase(email,password)
                .onSuccess {
                    updateLoginStatus(LoginStatus.SUCCESS)
                    fetchAndSetUserProfile()
                }.onFailure {
                    Timber.e(it)
                    updateLoginStatus(LoginStatus.ERROR)
                }
        }
    }
    private fun fetchAndSetUserProfile() {
        viewModelScope.launch {
            val profileResult = getLoginMemberUseCase.fetchLoginMemberProfile()
            Log.d("fetch", profileResult.toString())
//            if (profileResult) {
//                val profile = profileResult.data
//                signInViewModel.updateName(profile.name)
//                signInViewModel.updatePhoneNum(profile.phoneNumber)
//                signInViewModel.updateEmail(profile.email)
//            } else if (profileResult is Result.Failure) {
//            }
        }
    }

}