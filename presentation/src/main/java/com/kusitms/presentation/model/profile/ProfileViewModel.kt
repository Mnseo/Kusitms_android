package com.kusitms.presentation.model.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.domain.usecase.profile.GetProfileListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    getProfileListUseCase: GetProfileListUseCase,
) : ViewModel() {

    val profileList = getProfileListUseCase().catch {

    }.stateIn(
        viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = emptyList()
    )

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