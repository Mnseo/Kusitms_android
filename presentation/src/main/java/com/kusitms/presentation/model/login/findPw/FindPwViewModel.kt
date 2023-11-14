package com.kusitms.presentation.model.login.findPw

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FindPwViewModel: ViewModel() {
    val pw = MutableLiveData("")
    val isValid = MutableLiveData(false)

    init {
        pw.observeForever {
            isValid.value = it.isNotEmpty()
        }
    }
}