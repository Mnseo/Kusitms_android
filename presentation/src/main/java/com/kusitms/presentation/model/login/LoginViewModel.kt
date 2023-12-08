package com.kusitms.presentation.model.login

import androidx.lifecycle.ViewModel
import com.kusitms.presentation.model.signIn.InputState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _inputState = MutableStateFlow(InputState.DEFAULT)
    val inputState: StateFlow<InputState> = _inputState

    fun updateEmail(email: String) {
        _email.value = email
        if (email.isNotBlank()) {
            _inputState.value = InputState.ENTERED
        } else {
            _inputState.value = InputState.DEFAULT
        }
    }

    fun updatePassword(password: String) {
        _password.value = password
        if (password.isNotBlank()) {
            _inputState.value = InputState.ENTERED
        } else {
            _inputState.value = InputState.DEFAULT
        }
    }

    val isEmailValid:Boolean
        get() = email.value == "kusitms1234@naver.com"

    val isPasswordValid:Boolean
        get() = email.value == "kusitms1234@naver.com"

    fun validateEmail() {
        _inputState.value = if(isEmailValid) InputState.VALID else InputState.INVALID
    }

    fun validatePassword() {
        _inputState.value = if(isPasswordValid) InputState.VALID else InputState.INVALID
    }



}