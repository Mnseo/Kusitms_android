package com.kusitms.presentation.model.signIn

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.usecase.signin.SignInRequestCheckUseCase
import com.kusitms.domain.usecase.signin.SignInRequestUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
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
    private val signInRequestCheckUseCase: SignInRequestCheckUseCase,
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
        get() = signInResult.value == "CAN_REGISTER"

    private val _canNavigateToNextScreen = MutableStateFlow(false)
    val canNavigateToNextScreen: StateFlow<Boolean> = _canNavigateToNextScreen


    fun resetState() {
        _signInResult.value = ""
        _inputState.value = InputState.DEFAULT
        _email.value = ""
        _password.value = ""
        _canNavigateToNextScreen.value = false
    }


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

    fun signInRequestCheck() {
        viewModelScope.launch {
            val email = email.value
            val password = password.value
            signInRequestCheckUseCase(email, password)
                .onSuccess {
                    updateSignInResult(it.checkRegistered)
                    _canNavigateToNextScreen.value = isEmailValid
                    if(signInResult.value.equals("CAN_REGISTER")) {
                        signInRequestUseCase(email,password)
                    }
                }
                .onFailure {
                    Timber.e(it)
                }
        }
    }

}




