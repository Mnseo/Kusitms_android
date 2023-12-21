package com.kusitms.presentation.model.signIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.model.signin.SignInRequestModel
import com.kusitms.domain.usecase.signin.SignInRequestUseCase
import com.kusitms.presentation.model.login.LoginStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

enum class InputState {
    DEFAULT, ENTERED, VALID, INVALID
}

@HiltViewModel
class SignInRequestViewModel @Inject constructor(
    private val signInRequestUseCase: SignInRequestUseCase
): ViewModel() {

    private val _signInResult = MutableStateFlow("")
    val signInResult: StateFlow<String> = _signInResult

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _inputState = MutableStateFlow(InputState.DEFAULT)
    val inputState: StateFlow<InputState> = _inputState

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    val isEmailValid: Boolean
        get() = signInResult.value == "CAN_REGISTERED"


    fun updateSignInResult(signInResult: String) {
        _signInResult.value = signInResult
        validateEmail()
    }
    fun updateEmail(newEmail: String) {
        _email.value = newEmail
        _inputState.value = if (newEmail.isBlank()) InputState.DEFAULT else InputState.ENTERED
    }

    fun updatePassword(password: String) {
        _password.value = password
    }

    fun validateEmail() {
        _inputState.value = if (isEmailValid) InputState.VALID else InputState.INVALID
    }




    fun signInRequest() {
        viewModelScope.launch {
            val email = email.value
            val password = password.value
            signInRequestUseCase(email, password)
                .onSuccess {
                    updateSignInResult(it.checkRegistered)
                }
                .onFailure {
                    Timber.e(it)
                }
        }
    }

}




