package com.kusitms.presentation.model.login.findPw

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.usecase.changepw.UpdatePasswordAsLoggedInUseCase
import com.kusitms.domain.usecase.findpw.FindPwUpdatePasswordUseCase
import com.kusitms.presentation.model.signIn.InputState
import com.kusitms.presentation.ui.notice.detail.NoticeDetailViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class UpdatePwViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val updatePasswordAsLoggedInUseCase: UpdatePasswordAsLoggedInUseCase,
    private val updatePasswordUseCase: FindPwUpdatePasswordUseCase
): ViewModel() {

    val isAsLoggedIn: Boolean = savedStateHandle.get<Boolean>(UpdatePwViewModel.IS_AS_LOGGED_IN_SAVED_STATE_KEY)!!

    val verifiedEmail: String? = savedStateHandle.get("verifiedEmail")

    private val _newPw = MutableStateFlow("")
    val newPw: StateFlow<String> = _newPw

    private val _newPwConfirm = MutableStateFlow("")
    val newPwConfirm: StateFlow<String> = _newPwConfirm

    private val _passwordErrorState = MutableSharedFlow<UpdatePwViewModel.PasswordErrorState>()
    val passwordErrorState: SharedFlow<UpdatePwViewModel.PasswordErrorState> = _passwordErrorState

    fun updateNewPassword(newPw: String) {
        _newPw.value = newPw.trim()
        validateNewPassword()
    }


    fun updateNewPasswordConfirm(pw: String) {
        _newPwConfirm.value = pw.trim()
        validateNewPassword()
    }

    fun validateNewPassword() {
        viewModelScope.launch {
            when {
                _newPw.value.length <= 7 -> _passwordErrorState.emit(PasswordErrorState.ShortPassword)
                validatePassword( _newPw.value) -> _passwordErrorState.emit(PasswordErrorState.NotMatchRegex)
                _newPw.value != _newPwConfirm.value -> _passwordErrorState.emit(PasswordErrorState.PasswordsDoNotMatch)
                else -> _passwordErrorState.emit(PasswordErrorState.None)
            }
        }

    }


    fun validatePassword(password : String) : Boolean {
        val ps: Pattern =
            Pattern.compile("^[a-zA-Z0-9\\u318D\\u119E\\u11A2\\u2022\\u2025a\\u00B7\\uFE55]+$")
        if (ps.matcher(password).matches()) {
            return true
        }
        return false
    }

    fun changePassword() {
        viewModelScope.launch {
            if(isAsLoggedIn){
                updatePasswordAsLoggedInUseCase(newPw.value)
                    .catch {
                        //TODO
                    }.collect {
                        _passwordErrorState.emit(PasswordErrorState.Pass)
                    }
            } else {
                // 비회원일때 비밀번호 변경
                verifiedEmail?.let { email ->
                    Log.d("verifiedEmail", verifiedEmail.toString())
                    updatePasswordUseCase(email, newPw.value)
                        .onSuccess {
                            Log.d("비회원 로그인", "성공")
                            _passwordErrorState.emit(PasswordErrorState.Pass)
                        }
                        .onFailure {
                            Timber.e(it)
                        }
                }
            }
        }

    }



    enum class PasswordErrorState {
        None,
        ShortPassword,
        NotMatchRegex,
        PasswordsDoNotMatch,
        Pass
    }
    companion object {
        private const val IS_AS_LOGGED_IN_SAVED_STATE_KEY = "isAsLoggedIn"
    }
}