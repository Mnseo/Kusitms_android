package com.kusitms.presentation.model.signIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.usecase.signin.GetAuthTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


enum class TokenStatus { VALID, INVALID, DEFAULT }

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getAuthTokenUseCase: GetAuthTokenUseCase
): ViewModel() {

    private val _tokenStatus = MutableStateFlow(TokenStatus.DEFAULT)
    val tokenStatus: StateFlow<TokenStatus> = _tokenStatus

    fun updateTokenStatus(tokenStatus: TokenStatus) {
        _tokenStatus.value = tokenStatus
    }

    fun verifyToken() {
        viewModelScope.launch {
            getAuthTokenUseCase()
                .onSuccess { tokenModel ->
                    if (tokenModel != null) {
                        updateTokenStatus(TokenStatus.VALID)
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