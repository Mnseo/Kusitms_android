package com.kusitms.presentation.model.signIn

import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHostState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.usecase.home.GetNetworkStatusUseCase
import com.kusitms.domain.usecase.signin.GetAuthTokenUseCase
import com.kusitms.domain.usecase.signin.GetIsLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


enum class TokenStatus { VALID, INVALID, DEFAULT, SERVER }

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getAuthTokenUseCase: GetAuthTokenUseCase,
    private val getNetworkStatusUseCase: GetNetworkStatusUseCase,
    private val getIsLoginUseCase: GetIsLoginUseCase
): ViewModel() {

    private val _tokenStatus = MutableStateFlow(TokenStatus.DEFAULT)
    val tokenStatus: StateFlow<TokenStatus> = _tokenStatus

    private val _networkStatus = MutableStateFlow(true)
    val networkStatus : StateFlow<Boolean> = _networkStatus

    private val _isLogin = MutableStateFlow(true)
    val isLogin : StateFlow<Boolean> = _isLogin

    val snackbarHostState = SnackbarHostState()

    fun showInvalidTokenMessage() {
        viewModelScope.launch {
            val message = when {
                tokenStatus.value == TokenStatus.INVALID -> "토큰 상태가 유효하지 않습니다"
                !networkStatus.value -> "네트워크 연결 상태를 확인하세요"
                else -> return@launch
            }
            snackbarHostState.showSnackbar(
                message = message,
                duration = SnackbarDuration.Long
            )
        }
    }

    fun updateTokenStatus(tokenStatus: TokenStatus) {
        _tokenStatus.value = tokenStatus
    }
    init {
        verifyToken()
    }

    fun verifyToken() {
        viewModelScope.launch {
            getAuthTokenUseCase()
                .onSuccess { tokenModel ->
                    if (tokenModel != null) {
                        _networkStatus.value = getNetworkStatusUseCase()
                        if(_networkStatus.value) {
                            updateTokenStatus(TokenStatus.VALID)
                        }
                        else {
                            updateTokenStatus(TokenStatus.SERVER)
                            showInvalidTokenMessage()
                        }
                    } else {
                        // 토큰이 존재하지 않는 경우 (로그인 전)
                        updateTokenStatus(TokenStatus.DEFAULT)
                    }
                }
                .onFailure {
                    updateTokenStatus(TokenStatus.INVALID)
                    showInvalidTokenMessage()
                }
            getIsLoginUseCase()
                .onSuccess {
                if (it != null) {
                    _isLogin.value = it
                }
            }
                .onFailure {
                    _isLogin.value = false
                }
        }
    }
}