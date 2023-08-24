package com.kusitms.presentation.ui.login

import androidx.lifecycle.ViewModel
import com.kusitms.data.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {
}