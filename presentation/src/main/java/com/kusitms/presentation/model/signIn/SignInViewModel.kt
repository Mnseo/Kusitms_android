package com.kusitms.presentation.model.signIn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SignInViewModel:ViewModel() {
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

    fun updateMajor(newMajor: String) {
        _major.value = newMajor
    }

    fun updateSelectedPart(part: String) {
        _selectedPart.value = part
    }

    fun updateFavoriteCategory(categories: List<String>) {
        _favoriteCategory.value = categories
    }


    fun onButtonClick(): Boolean {
        return _isAllFieldsValid.value == true
    }

    private fun validateFields() {
        _isAllFieldsValid.value = !(_selectedPart.value.isNullOrBlank() || _favoriteCategory.value.isNullOrEmpty() || _major.value.isNullOrBlank())
    }

    fun showSnackbar() {
        _snackbarState.value = SnackbarState.Shown
    }

    fun hideSnackbar() {
        _snackbarState.value = SnackbarState.Hidden
    }

}