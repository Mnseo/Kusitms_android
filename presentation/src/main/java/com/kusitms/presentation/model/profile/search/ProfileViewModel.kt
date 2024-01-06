package com.kusitms.presentation.model.profile.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileSearchViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileSearchUiState())
    val uiState: StateFlow<ProfileSearchUiState> = _uiState.asStateFlow()

    fun changeSearchText(searchText: String) {
        _uiState.value = _uiState.value.copy(searchText = searchText)
    }

    fun clearSearchText() {
        changeSearchText("")
    }

    private fun fetchData(searchText: String) {
        viewModelScope.launch(Dispatchers.IO) {
//            val hasData = profileRepository.searchProfiles(searchText)

//            _uiState.value = _uiState.value.copy(hasData = hasData)
        }
    }
}