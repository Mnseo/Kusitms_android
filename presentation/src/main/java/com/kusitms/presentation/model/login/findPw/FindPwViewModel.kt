package com.kusitms.presentation.model.login.findPw

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FindPwViewModel: ViewModel() {
    val email = MutableLiveData("")
    val newPw= MutableLiveData("")
    val code = MutableLiveData("")
    val isValid = MutableLiveData(false)

    init {
        email.observeForever {
            isValid.value = it.isNotEmpty()
        }
    }
}