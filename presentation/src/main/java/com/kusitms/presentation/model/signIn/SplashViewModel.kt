package com.kusitms.presentation.model.signIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.usecase.home.GetNetworkStatusUseCase
import com.kusitms.domain.usecase.signin.GetAuthTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


enum class TokenStatus { VALID, INVALID, DEFAULT }

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getAuthTokenUseCase: GetAuthTokenUseCase,
    private val getNetworkStatusUseCase: GetNetworkStatusUseCase
): ViewModel() {

    private val _tokenStatus = MutableStateFlow(TokenStatus.DEFAULT)
    val tokenStatus: StateFlow<TokenStatus> = _tokenStatus

    private val _networkStatus = MutableStateFlow(false)
    val networkStatus : StateFlow<Boolean> = _networkStatus

    fun updateTokenStatus(tokenStatus: TokenStatus) {
        _tokenStatus.value = tokenStatus
    }

    fun updateNetworkStatus(networkStatus: Boolean) {
        _networkStatus.value = networkStatus
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
                        } else {
                            updateTokenStatus(TokenStatus.INVALID)
                        }
                    } else {
                        // 토큰이 존재하지 않는 경우 (로그인 전)
                        updateTokenStatus(TokenStatus.DEFAULT)
                    }
                }
                .onFailure {
                    updateTokenStatus(TokenStatus.INVALID)
                }
        }
    }


}