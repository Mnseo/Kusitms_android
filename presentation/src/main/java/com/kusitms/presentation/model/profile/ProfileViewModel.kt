package com.kusitms.presentation.model.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    private val _expanded = MutableStateFlow(false)
    val expended: StateFlow<Boolean> = _expanded.asStateFlow()

    fun changeSelectPart(part: String) {
        _uiState.value = _uiState.value.copy(currentSelectedPart = part)
        _expanded.value = false
    }

    fun toggleExpanded() {
        _expanded.value = !_expanded.value
    }
}