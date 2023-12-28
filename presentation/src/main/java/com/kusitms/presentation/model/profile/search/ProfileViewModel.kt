package com.kusitms.presentation.model.profile.search

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileSearchViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileSearchUiState())
    val uiState: StateFlow<ProfileSearchUiState> = _uiState.asStateFlow()

    fun changeSearchText(searchText: String) {
        _uiState.value = _uiState.value.copy(searchText = searchText)
    }
}