package com.kusitms.presentation.model.signIn

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

enum class InputState {
    DEFAULT, ENTERED, VALID, INVALID
}

class SignInRequestViewModel: ViewModel() {
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _inputState = MutableStateFlow(InputState.DEFAULT)
    val inputState: StateFlow<InputState> = _inputState

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    val isEmailValid: Boolean
        get() = email.value == "kusitms1234@naver.com"

    fun updateEmail(newEmail: String) {
        _email.value = newEmail
        _inputState.value = if (newEmail.isBlank()) InputState.DEFAULT else InputState.ENTERED
    }

    fun updatePassword(password: String) {
        _password.value = password
    }

    fun validateEmail() {
        _inputState.value = if(isEmailValid) InputState.VALID else InputState.INVALID
    }


}