package com.kusitms.presentation.model.signIn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kusitms.domain.model.login.LoginMemberProfile
import com.kusitms.domain.usecase.GetLoginMemberProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(

): ViewModel() {
    private val _major = MutableStateFlow("")
    val major: StateFlow<String> = _major

    private val _isAllFieldsValid = MutableStateFlow(false)
    val isAllFieldsValid: StateFlow<Boolean> = _isAllFieldsValid

    private val _snackbarState = MutableStateFlow(SnackbarState.Hidden)
    val snackbarState: StateFlow<SnackbarState> = _snackbarState

    private val _selectedPart = MutableStateFlow<String?>(null)
    val selectedPart: StateFlow<String?> = _selectedPart

    private val _favoriteCategory = MutableStateFlow<List<String>?>(null)
    val favoriteCategory: StateFlow<List<String>?> = _favoriteCategory

    private val _name = MutableStateFlow("이채연")
    val name: StateFlow<String> = _name

    private val _phoneNum = MutableStateFlow("010-1234-1234")
    val phoneNum: StateFlow<String> = _phoneNum

    private val _email = MutableStateFlow("kusitms@gmail.com")
    val email: StateFlow<String> = _email


    fun updateMajor(newMajor: String) {
        _major.value = newMajor
    }

    fun updateSelectedPart(part: String) {
        _selectedPart.value = part
    }

    fun updateFavoriteCategory(categories: List<String>) {
        _favoriteCategory.value = categories
    }

    fun updateName(newName: String) {
        _name.value = newName
    }

    fun updatePhoneNum(newPhoneNum: String) {
        _phoneNum.value = newPhoneNum
    }

    fun updateEmail(newEmail: String) {
        _email.value = newEmail
    }


    fun onButtonClick(): Boolean {
        return _isAllFieldsValid.value == true
    }

    private fun validateFields() {
        _isAllFieldsValid.value = !(_selectedPart.value.isNullOrBlank() || _favoriteCategory.value.isNullOrEmpty() || _major.value.isNullOrBlank())
    }


}