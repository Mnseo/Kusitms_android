package com.kusitms.presentation.model.signIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.model.login.LoginMemberProfile
import com.kusitms.domain.usecase.signin.AuthMemberProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authMemberProfileUseCase: AuthMemberProfileUseCase
): ViewModel() {
    private val _major = MutableStateFlow("")
    val major: StateFlow<String> = _major

    private val _isAllFieldsValid = MutableStateFlow(false)
    val isAllFieldsValid: StateFlow<Boolean> = _isAllFieldsValid

    private val _selectedPart = MutableStateFlow<String?>(null)
    val selectedPart: StateFlow<String?> = _selectedPart

    private val _favoriteCategory = MutableStateFlow<List<String>?>(null)
    val favoriteCategory: StateFlow<List<String>?> = _favoriteCategory

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _phoneNum = MutableStateFlow("")
    val phoneNum: StateFlow<String> = _phoneNum

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    init {
        loadLoginMemberProfile()
    }

    private fun loadLoginMemberProfile() {
        viewModelScope.launch {
            val result = authMemberProfileUseCase()
            result.onSuccess { profile ->
                profile?.let {
                    _name.value = it.name
                    _email.value = it.email
                    _phoneNum.value = it.phoneNumber
                }
            }
            result.onFailure {
                Timber.e(it)
            }
        }
    }

    fun updateMajor(newMajor: String) {
        _major.value = newMajor
    }

    fun updateSelectedPart(part: String) {
        _selectedPart.value = part
    }

    fun updateFavoriteCategory(selectedCategory: String) {
        val currentCategories = _favoriteCategory.value.orEmpty()
        if (currentCategories.contains(selectedCategory)) {
            _favoriteCategory.value = currentCategories - selectedCategory
        } else {
            _favoriteCategory.value = currentCategories + selectedCategory
        }
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