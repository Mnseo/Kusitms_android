package com.kusitms.presentation.model.login.findPw

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FindPwViewModel: ViewModel() {
    val id = MutableLiveData("")
    val isValid = MutableLiveData(false)

    init {
        id.observeForever {
            isValid.value = it.isNotEmpty()
        }
    }
}