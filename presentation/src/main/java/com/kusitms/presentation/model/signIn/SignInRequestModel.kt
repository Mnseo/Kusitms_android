package com.kusitms.presentation.model.signIn

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class SignInRequestModel: ViewModel() {
    private val email = MutableStateFlow("kusitms1234@naver.com")
}