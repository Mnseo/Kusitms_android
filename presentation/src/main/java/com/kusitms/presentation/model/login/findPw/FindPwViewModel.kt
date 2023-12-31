package com.kusitms.presentation.model.login.findPw


import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.usecase.changepw.CheckPasswordUseCase
import com.kusitms.domain.usecase.findpw.FindPwCodeVerifyUseCase
import com.kusitms.domain.usecase.findpw.FindPwEmailVerifyUseCase
import com.kusitms.domain.usecase.findpw.FindPwSendCodeUseCase
import com.kusitms.domain.usecase.findpw.FindPwUpdatePasswordUseCase
import com.kusitms.presentation.model.signIn.InputState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class FindPwViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val findPwEmailVerifyUseCase: FindPwEmailVerifyUseCase,
    private val findPwSendCodeUseCase: FindPwSendCodeUseCase,
    private val checkPasswordUseCase: CheckPasswordUseCase,
    private val findPwCodeVerifyUseCase: FindPwCodeVerifyUseCase,
): ViewModel() {
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _passwordErrorState = MutableSharedFlow<PasswordErrorState>()
    val passwordErrorState: SharedFlow<PasswordErrorState> = _passwordErrorState

    private val _code = MutableStateFlow("")
    val code: StateFlow<String> = _code

    private val _inputState = MutableStateFlow(InputState.DEFAULT)
    val inputState: StateFlow<InputState> = _inputState

    private val _timeLeft = MutableStateFlow(300)
    val timeLeft:StateFlow<Int> = _timeLeft

    private val _emailState = MutableStateFlow(EmailState.NonPASS)
    val emailState: StateFlow<EmailState> = _emailState

    private val _isTimerFinished = MutableStateFlow(false)
    val isTimerFinished: StateFlow<Boolean> = _isTimerFinished

    fun resetState() {
        _inputState.value = InputState.DEFAULT
    }

    fun resetInput() {
        _email.value = ""
        _password.value = ""
        _code.value = ""

    }

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

    fun onEmailVerificationSuccess(email: String) {
        savedStateHandle.set("verifiedEmail", email)
    }



    fun updatePasswordState(responseState: Boolean) {
        viewModelScope.launch {
            _passwordErrorState.emit(if(responseState) PasswordErrorState.Pass else PasswordErrorState.NotCurrentPw)
        }

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
            _isTimerFinished.value = true
            _inputState.value = InputState.INVALID
        }
    }
    fun validateEmail() {
        viewModelScope.launch {
            val email = email.value
            findPwEmailVerifyUseCase(email)
                .onSuccess { result ->
                    _emailState.value = if(result.isEmailExist) EmailState.PASS else EmailState.NonPASS
                    _inputState.value = if(result.isEmailExist) InputState.VALID else InputState.INVALID
                    Log.d("EmailState", emailState.value.toString())
                    Log.d("inputState", inputState.value.toString())
                    if(emailState.value == EmailState.PASS) {
                        findPwSendCodeUseCase(email)
                    }
                }
                .onFailure {
                    Timber.e(it)
                    _emailState.value = EmailState.NonPASS
                    _inputState.value = InputState.INVALID
                }
        }
    }

    fun validateCode() {
        viewModelScope.launch {
            val email = email.value
            val code = code.value
            findPwCodeVerifyUseCase(email, code)
                .onSuccess { result ->
                    _inputState.value = if(result.isVerified) InputState.VALID else InputState.INVALID
                    onEmailVerificationSuccess(email)
                }
                .onFailure {
                    Timber.e(it)
                    _inputState.value = InputState.INVALID
                }
        }
    }


    fun validatePassword(password : String){
        viewModelScope.launch {
            checkPasswordUseCase(password)
                .catch {
                    //TODO
                }.collect{
                    if(it){
                        _passwordErrorState.emit(PasswordErrorState.Pass)
                    }else {
                        _passwordErrorState.emit(PasswordErrorState.NotCurrentPw)
                    }
                }
        }
    }

    enum class EmailState {
        PASS,
        NonPASS
    }

    enum class PasswordErrorState {
        None,
        ShortPassword,
        PasswordsDoNotMatch,
        NotCurrentPw,
        Pass
    }

}