package com.kusitms.presentation.model.login.findPw

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.usecase.changepw.UpdatePasswordAsLoggedInUseCase
import com.kusitms.presentation.ui.notice.detail.NoticeDetailViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdatePwViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val updatePasswordAsLoggedInUseCase: UpdatePasswordAsLoggedInUseCase
): ViewModel() {

    val isAsLoggedIn: Boolean = savedStateHandle.get<Boolean>(UpdatePwViewModel.IS_AS_LOGGED_IN_SAVED_STATE_KEY)!!

    private val _newPw = MutableStateFlow("")
    val newPw: StateFlow<String> = _newPw

    private val _newPwConfirm = MutableStateFlow("")
    val newPwConfirm: StateFlow<String> = _newPwConfirm

    private val _passwordErrorState = MutableSharedFlow<FindPwViewModel.PasswordErrorState>()
    val passwordErrorState: SharedFlow<FindPwViewModel.PasswordErrorState> = _passwordErrorState

    fun updateNewPassword(newPw: String) {
        _newPw.value = newPw
        validateNewPassword()
    }


    fun updateNewPasswordConfirm(pw: String) {
        _newPwConfirm.value = pw
        validateNewPassword()
    }

    fun validateNewPassword() {
        viewModelScope.launch {
            when {
                _newPw.value.length < 5 -> _passwordErrorState.emit(FindPwViewModel.PasswordErrorState.ShortPassword)
                _newPw.value != _newPwConfirm.value -> _passwordErrorState.emit(FindPwViewModel.PasswordErrorState.PasswordsDoNotMatch)
                else -> _passwordErrorState.emit(FindPwViewModel.PasswordErrorState.None)
            }
        }

    }


    fun changePassword() {
        viewModelScope.launch {
            if(isAsLoggedIn){
                updatePasswordAsLoggedInUseCase(newPw.value)
                    .catch {
                        //TODO
                    }.collect {
                        _passwordErrorState.emit(FindPwViewModel.PasswordErrorState.Pass)
                    }
            } else {
                //비로그인 비밀번호 변경
            }
        }

    }



    enum class PasswordErrorState {
        None,
        ShortPassword,
        PasswordsDoNotMatch,
        Pass
    }
    companion object {
        private const val IS_AS_LOGGED_IN_SAVED_STATE_KEY = "isAsLoggedIn"
    }
}