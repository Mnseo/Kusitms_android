package com.kusitms.presentation.model.login.findPw


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.usecase.findpw.FindPwEmailVerifyUseCase
import com.kusitms.presentation.model.signIn.InputState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindPwViewModel @Inject constructor(
    private val findPwEmailVerifyUseCase: FindPwEmailVerifyUseCase
): ViewModel() {
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _newPw = MutableStateFlow("")
    val newPw: StateFlow<String> = _newPw

    private val _newPwConfirm = MutableStateFlow("")
    val newPwConfirm: StateFlow<String> = _newPwConfirm

    private val _passwordErrorState = MutableStateFlow<PasswordErrorState>(PasswordErrorState.None)
    val passwordErrorState: StateFlow<PasswordErrorState> = _passwordErrorState

    private val _code = MutableStateFlow("")
    val code: StateFlow<String> = _code

    private val _inputState = MutableStateFlow(InputState.DEFAULT)
    val inputState: StateFlow<InputState> = _inputState

    private val _timeLeft = MutableStateFlow(300)
    val timeLeft:StateFlow<Int> = _timeLeft

    val isCodeValid:Boolean
        get() = code.value == "123456"

    val isEmailValid:Boolean
        get() = email.value == "kusitms1234@naver.com"

    fun updateEmail(email: String) {
        _email.value = email
        if (email.isNotBlank()) {
            _inputState.value = InputState.ENTERED
        } else {
            _inputState.value = InputState.DEFAULT
        }
    }
    fun updatePassword(Pw: String) {
        _password.value = Pw
    }

    fun updateNewPassword(newPw: String) {
        _newPw.value = newPw
        validateNewPassword()
    }

    fun updatePasswordState(responseState: Boolean) {
        _passwordErrorState.value = if(responseState) PasswordErrorState.Pass else PasswordErrorState.NotCurrentPw
    }

    fun updateNewPasswordConfirm(pw: String) {
        _newPwConfirm.value = pw
        validateNewPassword()
    }

    fun updateCode(newCode: String) {
        _code.value = newCode
        if (newCode.isNotBlank()) {
            _inputState.value = InputState.ENTERED
        } else {
            _inputState.value = InputState.DEFAULT
        }
    }

    fun startCountDown(totalSeconds: Int) {
        viewModelScope.launch {
            for(i in totalSeconds downTo 0) {
                _timeLeft.value = i
                delay(1000)
            }
        }
    }
    fun validateEmail() {
        _inputState.value = if(isEmailValid) InputState.VALID else InputState.INVALID
    }

    fun validateCode() {
        _inputState.value = if(isCodeValid) InputState.VALID else InputState.INVALID
    }


    fun validateNewPassword() {
        when {
            _newPw.value.length < 8 -> _passwordErrorState.value = PasswordErrorState.ShortPassword
            _newPw.value != _newPwConfirm.value -> _passwordErrorState.value = PasswordErrorState.PasswordsDoNotMatch
            else -> _passwordErrorState.value = PasswordErrorState.None
        }
    }

    enum class PasswordErrorState {
        None,
        ShortPassword,
        PasswordsDoNotMatch,
        NotCurrentPw,
        Pass
    }


}