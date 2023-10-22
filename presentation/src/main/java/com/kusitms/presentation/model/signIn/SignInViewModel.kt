package com.kusitms.presentation.model.signIn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignInViewModel:ViewModel() {
    private val _major = MutableLiveData<String>("")
    val major: LiveData<String> = _major

    private val _email = MutableLiveData<String>("")
    val email: LiveData<String> = _email

    private val _phoneNum = MutableLiveData<String>("")
    val phoneNum: LiveData<String> = _phoneNum

    fun updateMajor(newMajor: String) {
        _major.value = newMajor
    }

    fun updateEmail(newEmail: String) {
        _email.value = newEmail
    }

    fun updatePhoneNum(newNumber: String) {
        _phoneNum.value = newNumber
    }

}