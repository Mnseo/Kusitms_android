package com.kusitms.presentation.model.signIn

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SignInRequestModel: ViewModel() {
    private val _email = MutableStateFlow("kusitms1234@naver.com")
    val email: StateFlow<String> = _email

    private val _emailInputState = MutableStateFlow(EmailInputState.DEFAULT)
    val emailInputState: StateFlow<EmailInputState> = _emailInputState

    val isEmailValid: Boolean
        get() = email.value == "kusitms1234@naver.com"

    fun updateEmail(newEmail: String) {
        _email.value = newEmail
        _emailInputState.value = if (newEmail.isBlank()) EmailInputState.DEFAULT else EmailInputState.ENTERED
    }

    fun validateEmail() {
        _emailInputState.value = if(isEmailValid) EmailInputState.VALID else EmailInputState.INVALID
    }

    enum class EmailInputState {
        DEFAULT, ENTERED, VALID, INVALID
    }

}