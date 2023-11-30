package com.kusitms.presentation.model.login.findPw

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.presentation.model.signIn.InputState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FindPwViewModel: ViewModel() {
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _newPw = MutableStateFlow("")
    val newPw: StateFlow<String> = _newPw

    private val _code = MutableStateFlow("")
    val code: StateFlow<String> = _code

    private val _inputState = MutableStateFlow(InputState.DEFAULT)
    val inputState: StateFlow<InputState> = _inputState

    private val _timeLeft = MutableStateFlow(300)
    val timeLeft:StateFlow<Int> = _timeLeft

    val isValid = MutableLiveData(false)

    val isCodeValid:Boolean
        get() = code.value == "123456"

    fun updateEmail(email: String) {
        _email.value = email
    }

    fun updateNewPassword(newPw: String) {
        _newPw.value = newPw
    }

    fun updateCode(newCode: String) {
        _code.value = newCode
    }

    fun startCountDown(totalSeconds: Int) {
        viewModelScope.launch {
            for(i in totalSeconds downTo 0) {
                _timeLeft.value = i
                delay(1000)
            }
        }
    }

    fun validateCode() {
        _inputState.value = if(isCodeValid) InputState.VALID else InputState.INVALID
    }
}